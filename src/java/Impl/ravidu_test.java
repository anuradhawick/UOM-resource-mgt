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
import model.foundation.Reservation;
import model.foundation.Resource;
import model.foundation.ResourceView;
import model.logic.ReservationHandler;
import model.logic.ResourceHandler;

/**
 *
 * @author RAVIDU-PC
 */
public class ravidu_test {

    public static void main(String[] args) throws SQLException, ParseException {
        DBSearchHandler han=new DBSearchHandler();
        String date1="2016-01-16";
        String date2="2016-01-18";
        SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");
        Date d1=fm.parse(date1);
        Date d2=fm.parse(date2);
        ArrayList<Reservation> res=han.getReservationHistory(d1, d2);
        for (Reservation r:res) {
            System.out.println(r.getCapacity());
        }
        
        
    }
}
