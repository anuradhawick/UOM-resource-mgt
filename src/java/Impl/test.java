/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import data.DBPrivilegeUserHandler;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import model.foundation.AuthorizedPerson;
import model.foundation.Person;
import model.foundation.Privilege;

/**
 *
 * @author RAVIDU-PC
 */
public class test {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {
        DBPrivilegeUserHandler d = new DBPrivilegeUserHandler();
        AuthorizedPerson p =new AuthorizedPerson();
        p.setUsername("admin");
        p.setPassword("admin");
        Person pp = new Person("1","Fname" , "Mname", "Lname");
        Privilege pr = new Privilege("user");
        d.updateDetails(p, pp, pr);
    }

}
