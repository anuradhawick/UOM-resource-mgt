/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
        Connection connection = DBConnector.connect();

        String query = "SELECT * FROM resource_management.person S where S.ID IN (SELECT ID FROM resource_management.authorized_person A WHERE A.username = ? )";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, p.getUsername());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            person.setFirstName(resultSet.getString("first_name"));
            person.setLastName(resultSet.getString("last_name"));
            person.setMiddleName(resultSet.getString("middle_name"));
            person.setId(resultSet.getString("ID"));
            return person;
        }
        return null;

    }

    public HashMap<String, Integer> getPrivilegesHash(Person p) throws SQLException {
        HashMap<String, Integer> priv = new HashMap<>();
        ArrayList<Privilege> priv_list = new DBPrivilegeUserHandler().getPrivileges(p);
        for (Privilege priv_list1 : priv_list) {
            priv.put(priv_list1.getPrivName(), 1);
        }
        return priv;
    }
}
