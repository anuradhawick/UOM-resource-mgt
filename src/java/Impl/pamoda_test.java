/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import data.DBPrivilegeUserHandler;
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
public class pamoda_test {

    public static void main(String[] args) throws SQLException {
        ArrayList<Privilege> priv_list = new ArrayList();
        HashMap<String,Integer> priv = new HashMap<>();
        Person p = new Person();
        p.setId("1");
        DBPrivilegeUserHandler dbph = new DBPrivilegeUserHandler();
        priv_list = dbph.getPrivileges(p);
        for (Privilege priv_list1 : priv_list) {
            System.out.println(priv_list1.getPrivName());
            priv.put(priv_list1.getPrivName(), 1);
        }
        System.out.println(priv.containsKey("admin"));
        
//        AuthorizedPerson p = new AuthorizedPerson();
//        p.setUsername("admin");
//        DBPrivilegeUserHandler dbh = new DBPrivilegeUserHandler();
//        Person person = dbh.getLoggedPerson(p);
//        System.out.println(person.getId());
    }
}
