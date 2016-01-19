package model.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.foundation.Reservation;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dulaj
 */
public class ReservationHandlerTest {
    
    @Test
    public void testIsAvailable() {
        int resourceID = 10001;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = sdf.parse("2015-12-16 13:00:00");
            endTime = sdf.parse("2015-12-16 17:00:00");
        } catch (ParseException ex) {
            fail();
        }
        
        ReservationHandler instance = new ReservationHandler();
        assertEquals(true, instance.isAvailable(resourceID, startTime, endTime));
    }

    @Test
    public void testAddReservation() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = sdf.parse("2015-12-16 08:00:00");
            endTime = sdf.parse("2015-12-16 12:00:00");
            System.out.println(startTime.toString());
            System.out.println(endTime.toString());
        } catch (ParseException ex) {
            fail();
        }
        
     //   Reservation reservation = new Reservation(100, startTime, endTime, "10001", "130047D");
        ReservationHandler instance = new ReservationHandler();
     //   assertEquals(true, instance.addReservation(reservation));
    }

    @Test
    public void testDeleteReservation() {
        int reservationID = 28;
        ReservationHandler instance = new ReservationHandler();
        instance.deleteReservation(reservationID);
    }

    @Test
    public void testModifyReservation() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = sdf.parse("2015-12-16 09:00:00");
            endTime = sdf.parse("2015-12-16 11:00:00");
            System.out.println(startTime.toString());
            System.out.println(endTime.toString());
        } catch (ParseException ex) {
            fail();
        }
        
    //    Reservation reservation = new Reservation(100, startTime, endTime, "10001", "130047D");
      //  reservation.setReserveId(49);
        //ReservationHandler instance = new ReservationHandler();
        //assertEquals(true, instance.modifyReservation(reservation));
    }
}