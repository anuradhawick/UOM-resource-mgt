/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Authenticator.Authenticator;
import data.DBAuthenticatorHandler;
import data.DBInsertDeleteHandler;
import data.DBSearchHandler;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import model.foundation.Department;
import model.foundation.Hall;
import model.foundation.MaintenanceTool;
import model.foundation.*;
import model.logic.ReservationHandler;
import model.logic.ResourceHandler;

/**
 *
 * @author RAVIDU-PC
 */
public class test {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException, ParseException {
        DBSearchHandler ahndle=new DBSearchHandler();
        Hall r=(Hall)ahndle.SearchResource("Hall", 8);
        System.out.println(r.getCapacityAmount()+" "+r.getCategory()+" "+r.getDescription()+" "+r.getResourceName()+" "+r.getResourceid()+" "+r.getDepartment().getBuilding());
    }

}
