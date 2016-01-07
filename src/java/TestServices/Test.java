/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestServices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Pamoda
 */
public class Test {

    public static void main(String[] args) throws ParseException {
       // SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss ");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        
        System.out.println(formatter.format(date));
    }
}
