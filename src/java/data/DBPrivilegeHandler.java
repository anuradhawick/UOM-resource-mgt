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
import model.foundation.Person;
import model.foundation.Privilege;

/**
 *
 * @author Pamoda
 */
public class DBPrivilegeHandler {
    //authorizeed person object
    //priv array return
    public ArrayList<Privilege> getPrivileges(Person p) throws SQLException {
        ArrayList<Privilege> priv_list = new ArrayList();
        Connection connection = DBConnector.connect(); 
        
        String query = "SELECT * FROM resource_management.person_priv INNER JOIN resource_management.authorized_person USING(ID)"
                        + "WHERE ID='" + p.getId() + "'";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
      
        while (resultSet.next()) {
            Privilege pri = new Privilege();
            pri.setPrivName(resultSet.getString("priv_name"));
            priv_list.add(pri);
        }
        return priv_list;

    }
}
