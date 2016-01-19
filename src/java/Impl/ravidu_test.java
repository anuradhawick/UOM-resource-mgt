/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import data.DBSearchHandler;
import data.DBSelectHandler;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.foundation.Department;
import model.foundation.Hall;
import model.foundation.Lab;
import model.foundation.MaintenanceTool;
import model.foundation.Reservation;
import model.foundation.Resource;
import model.foundation.ResourceView;
import model.foundation.SportItem;
import model.foundation.SportPlace;
import model.foundation.Vehicle;
import model.logic.ReservationHandler;
import model.logic.ResourceHandler;

/**
 *
 * @author RAVIDU-PC
 */
public class ravidu_test {

    public static void main(String[] args) throws SQLException, ParseException {
       DBSelectHandler hn=new DBSelectHandler();
       String statr="2016-01-21 09:21:00";
       String end="2016-01-23 12:00:00";
       SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date dd1=f.parse(statr);
       Date e=f.parse(end);
       Reservation re=new Reservation();
       re.setPersonId("1");
    //   re.setResourceId("1");
       re.setStartTime(dd1);
       re.setEndTime(e);
       re.setApproval(1);
       re.setPurpose("Good");
       ReservationHandler han=new ReservationHandler();
        System.out.println(han.addReservation(re));
       
        
        
    }
}
