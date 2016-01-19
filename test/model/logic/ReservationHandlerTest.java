package model.logic;

import data.DBReservationHandler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public void testAddReservation() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = sdf.parse("2015-12-16 08:00:00");
            endTime = sdf.parse("2015-12-16 12:00:00");
            System.out.println(startTime.toString());
            System.out.println(endTime.toString());
            Reservation re = new Reservation();
            re.setResourceId(1);
            re.setPersonId("1");
            re.setStartTime(startTime);
            re.setEndTime(endTime);
            re.setApproval(1);
            re.setCapacity(67);
            re.setPurpose("Purpose");
        } catch (ParseException ex) {
            fail();
        }

        Reservation reservation = new Reservation(100, startTime, endTime, 1, "1", 1, "Purpose");
        ReservationHandler instance = new ReservationHandler();
        assertEquals(true, instance.addReservation(reservation));
    }
}
