/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Authenticator.Authenticator;
import data.DBAuthenticatorHandler;
import data.DBInsertDeleteHandler;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import model.foundation.Department;
import model.foundation.Hall;
import model.foundation.MaintenanceTool;
import model.foundation.ResourceView;
import model.logic.ResourceHandler;

/**
 *
 * @author RAVIDU-PC
 */
public class test {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {
        Authenticator a = new Authenticator("admin", "admin");
        DBAuthenticatorHandler db = new DBAuthenticatorHandler();
        boolean success = db.login(a);
        System.out.println(success);

    }

}
