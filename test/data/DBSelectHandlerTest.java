/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.foundation.Reservation;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dulaj
 */
public class DBSelectHandlerTest {
    
    public DBSelectHandlerTest() {
    }

    @Test
    public void testIsAvailable() throws Exception {
        System.out.println("isAvailable");
        int resourceID = 1;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = sdf.parse("2015-12-16 08:00:00");
            endTime = sdf.parse("2015-12-16 12:00:00");
        } catch (ParseException ex) {
            fail();
        }
        
        DBSelectHandler db=new DBSelectHandler();
        assertEquals(true, db.isAvailable(resourceID, startTime, endTime));
    }
    
}
