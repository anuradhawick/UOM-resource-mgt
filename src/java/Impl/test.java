/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Authenticator.Authenticator;
import data.DBAuthenticatorHandler;
import data.DBConnector;
import data.DBInsertDeleteHandler;
import data.DBSearchHandler;
import data.DBSelectHandler;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
        String d = "2016-01-16";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(d);
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY,13);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        date=cal.getTime();
        System.out.println(date);
        DBSelectHandler gn=new DBSelectHandler();
        gn.isAvailable("8", date, date);
        
        for (int i = 0; i < 15; i++) {
            DBInsertDeleteHandler gh=new DBInsertDeleteHandler();
            SportPlace p=new SportPlace();
            p.setResourceName("Sport"+i);
            p.setCapacityAmount(i*5);
            p.setDescription("Good");
            p.setCategory("Sport Place");
            p.setLocation("Underground");
            p.setDescription("Good condition");
            gh.insertSportPlace(p);
            
        }
        

    }

}
