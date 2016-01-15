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
import model.foundation.Resource;
import model.foundation.ResourceView;
import model.logic.ReservationHandler;
import model.logic.ResourceHandler;
import org.jboss.weld.SimpleCDI;

/**
 *
 * @author RAVIDU-PC
 */
public class ravidu_test {

    public static void main(String[] args) throws SQLException, ParseException {

        DBSelectHandler han=new DBSelectHandler();
        String Starttime="2016-01-16 10:00:00";
        String EndTime="2016-01-16 14:00:00";
        SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start=fm.parse(Starttime);
        Date end=fm.parse(EndTime);
        System.out.println(han.isAvailable("8", start, end));
        
        
    }
}
