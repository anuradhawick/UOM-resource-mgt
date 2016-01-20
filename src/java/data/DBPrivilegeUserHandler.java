/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import model.foundation.AuthorizedPerson;
import model.foundation.Person;
import model.foundation.Privilege;

/**
 *
 * @author Pamoda
 */
public class DBPrivilegeUserHandler {

    //authorizeed person object
    //priv array return
    private Connection connection;
    private PreparedStatement statement;

    public ArrayList<Privilege> getPrivileges(Person p) throws SQLException {
        ArrayList<Privilege> priv_list = new ArrayList();
        Connection connection = DBConnector.connect();

        String query = "SELECT * FROM resource_management.person_priv INNER JOIN resource_management.authorized_person USING(ID) WHERE ID = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, p.getId());
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Privilege pri = new Privilege();
            pri.setPrivName(resultSet.getString("priv_name"));
            priv_list.add(pri);
        }
        return priv_list;
    }

    public Person getLoggedPerson(AuthorizedPerson p) throws SQLException {
        Person person = new Person();
        connection = DBConnector.connect();

        String query = "SELECT * FROM resource_management.person S where S.ID IN (SELECT ID FROM resource_management.authorized_person A WHERE A.username = ? )";

        statement = connection.prepareStatement(query);
        statement.setString(1, p.getUsername());
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            person.setFirstName(resultSet.getString("first_name"));
            person.setLastName(resultSet.getString("last_name"));
            person.setMiddleName(resultSet.getString("middle_name"));
            person.setId(resultSet.getString("ID"));
        }

        statement = connection.prepareStatement("SELECT img FROM resource_management.person_img i JOIN resource_management.person p WHERE i.person_ID=p.ID AND p.ID=?");
        statement.setString(1, person.getId());
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            InputStream d = resultSet.getBinaryStream("img");
            person.setImage(d);
        }

        return person;

    }

    public HashMap<String, Integer> getPrivilegesHash(Person p) throws SQLException {
        HashMap<String, Integer> priv = new HashMap<>();
        ArrayList<Privilege> priv_list = new DBPrivilegeUserHandler().getPrivileges(p);
        for (Privilege priv_list1 : priv_list) {
            priv.put(priv_list1.getPrivName(), 1);
        }
        return priv;
    }

    public void addAdmin(AuthorizedPerson ap, Privilege priv) throws SQLException {
        DBInsertDeleteHandler dbih = new DBInsertDeleteHandler();
        Person person = getLoggedPerson(ap);
        dbih.insertInto_person_priv(person, priv);
    }

    public boolean updateDetails(AuthorizedPerson ap, Person p, Privilege priv) {
        connection = DBConnector.connect();
        try {
            String up_p = "";
            statement = connection.prepareStatement("UPDATE `resource_management`.`person` SET first_name=?, middle_name=?, last_name=? WHERE ID=?");
            System.out.println(p.getFirstName());
            statement.setString(1, p.getFirstName());
            statement.setString(2, p.getMiddleName());
            statement.setString(3, p.getLastName());
            statement.setString(4, p.getId());
            System.out.println(p.getId());
            System.out.println(statement.executeUpdate());
//            System.out.println("UPDATE `resource_management`.`person` SET first_name='" + p.getFirstName() + "', middle_name='" + p.getMiddleName() + "',last_name='" + p.getLastName() + "' WHERE `ID`='" + p.getId() + "'");
//            statement.execute("UPDATE `resource_management`.`person` SET first_name='" + p.getFirstName() + "', middle_name='" + p.getMiddleName() + "',last_name='" + p.getLastName() + "' WHERE `ID`='" + p.getId() + "'");
            statement.clearParameters();
            statement.close();

//            String up_ap = "UPDATE resource_management.authorized_person SET password=? WHERE username = ?";
//            statement = connection.prepareStatement(up_p);
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            md.update(ap.getPassword().getBytes());
//            byte[] mdbytes = md.digest();
//
//            //convert the byte to hex format method 1
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < mdbytes.length; i++) {
//                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
//            }
//            statement.setString(1, sb.toString());
//            statement.setString(2, ap.getUsername());
//            statement.executeUpdate();
//            statement.clearParameters();
//
//            statement.close();
//            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                return false;
            }
        }

    }

    public boolean updateImage(Person p) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("SELECT * FROM resource_management.person_img WHERE person_ID=?");
        statement.setString(1, p.getId());
        ResultSet set = statement.executeQuery();
        if (set.next()) {
            statement = connection.prepareStatement("UPDATE resource_management.person_img SET img=? WHERE person_ID=?");
            statement.setBinaryStream(1, p.getImage());
            statement.setString(2, p.getId());
            statement.executeUpdate();
        } else {
            statement = connection.prepareStatement("INSERT INTO resource_management.person_img (person_ID,img) VALUES(?,?)");
            statement.setBinaryStream(2, p.getImage());
//            statement.setBinaryStream(3, p.getImage());
            statement.setString(1, p.getId());
            statement.execute();
        }

        statement.clearParameters();
        statement.close();

        connection.close();

        return true;
    }

    public boolean checkUsername(AuthorizedPerson ap) throws SQLException {
        connection = DBConnector.connect();
        String query = "SELECT username FROM resource_management.authorized_person WHERE username= ? LIMIT 1";
        statement = connection.prepareStatement(query);
        statement.setString(1, ap.getUsername());
        ResultSet rs = statement.executeQuery();
        connection.close();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNormalUser(String username) throws SQLException {
        connection = DBConnector.connect();
        String query = "SELECT username,id FROM resource_management.authorized_person WHERE username= ? LIMIT 1";
        statement = connection.prepareStatement(query);
        statement.setString(1, username);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            query = "SELECT id FROM resource_management.person_priv WHERE id= ? and priv_name = ? LIMIT 1";
            statement = connection.prepareStatement(query);
            statement.setString(1, rs.getString(1));
            statement.setString(2, "user");
            rs = statement.executeQuery();
            connection.close();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } else {
            connection.close();
            return false;
        }
    }

    public Person getPersonbyID(String id) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("SELECT * FROM person where ID=?");
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Person p = new Person();
            p.setFirstName(resultSet.getString("first_name"));
            p.setMiddleName(resultSet.getString("middle_name"));
            p.setLastName(resultSet.getString("last_name"));
            p.setId(resultSet.getString("ID"));
            return p;
        }
        return null;
    }
}
