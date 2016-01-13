/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import data.DBPrivilegeHandler;
import java.sql.SQLException;
import java.util.ArrayList;
import model.foundation.Person;
import model.foundation.Privilege;

/**
 *
 * @author Pamoda
 */

public class pamoda_test {
    public static void main(String[] args) throws SQLException {
        ArrayList<Privilege> priv_list = new ArrayList();
        Person p = new Person();
        p.setId("130944E");
        DBPrivilegeHandler dbph = new DBPrivilegeHandler();
        priv_list = dbph.getPrivileges(p);
        for (Privilege priv_list1 : priv_list) {
            System.out.print(priv_list1.getPrivName());
        }
    }
}
