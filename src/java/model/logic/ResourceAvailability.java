/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logic;

import data.DBSearchHandler;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author RAVIDU-PC
 */
public class ResourceAvailability {
    
      public void getAvailableTime(String resourceid,Date date,Date startTime, Date endTime) throws ParseException{
        try {
            DBSearchHandler hand=new DBSearchHandler();
            for (int i = 5; i < 22; i++) {
            String start=i+":00:00";
            String end=(i+1)+":00:00";
            SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
            Time starttime=new Time(format.parse(start).getTime());
            Time endtime=new Time(format.parse(start).getTime());
           // if(hand.checkAvailability(resourceid, date, starttime, null)){}
            
            
        }
            
        } catch (Exception e) {
        }
        
    }
    
}
