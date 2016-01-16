package model.logic;

import data.DBInsertDeleteHandler;
import data.*;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import model.foundation.Reservation;
import org.apache.log4j.Logger;

/**
 *
 * @author Dulaj
 */
public class ReservationHandler {

    private static Logger logger = Logger.getLogger(ReservationHandler.class);

    public ReservationHandler() {
    }

    public boolean isAvailable(String resourceID, Date startTime, Date endTime) {
        try {
            return new DBSelectHandler().isAvailable(resourceID, startTime, endTime);
        } catch (SQLException ex) {
            logger.error("Checking resource isAvailable failed", ex);
            return false;
        }
    }

    public int addReservation(Reservation reservation) {
        if (isAvailable(reservation.getResourceId(), reservation.getStartTime(), reservation.getEndTime())) {
            try {
                return new DBInsertDeleteHandler().insertReservation(reservation);
            } catch (SQLException ex) {
                logger.error("Insert reservation failed", ex);
            }

        } else {
            return -1;
        }
        return -1;
    }

    public void deleteReservation(int reservationID) {
        try {
            new DBInsertDeleteHandler().deleteReservation(reservationID);
        } catch (SQLException ex) {
            logger.error("Delete reservation failed", ex);
        }
    }

    public int modifyReservation(Reservation reservation) {
        deleteReservation(reservation.getReserveId());
        return addReservation(reservation);
    }

    public void checkAvailability(String resourceID, Date date) {
        Date d1 = date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        ReservationHandler handle = new ReservationHandler();
        for (int i = 5; i < 22; i++) {
            cal.set(Calendar.HOUR_OF_DAY, i);
            cal.set(Calendar.MINUTE, 00);
            cal.set(Calendar.SECOND, 00);
            date = cal.getTime();

            cal1.set(Calendar.HOUR_OF_DAY, i + 1);
            cal1.set(Calendar.MINUTE, 00);
            cal1.set(Calendar.SECOND, 00);
            d1 = cal1.getTime();

            if (handle.isAvailable(resourceID, date, d1)) {
                System.out.println("Start:" + i + " End:" + (i + 1));
            }
        }
    }

    public ArrayList<Reservation> getApprovedReservationHistory(Date startdate, Date enddate) throws SQLException {
        return new DBSearchHandler().getApprovedReservationHistory(startdate, enddate);
    }

    public ArrayList<Reservation> getRejectedReservationHistory(Date startdate, Date enddate) throws SQLException {
        return new DBSearchHandler().getRejectedReservationHistory(startdate, enddate);
    }

    public ArrayList<Reservation> getOverallReservationHistory(Date startdate, Date enddate) throws SQLException {
        return new DBSearchHandler().getReservationHistory(startdate, enddate);
    }

    public ArrayList<Reservation> getPendingReservation(Date startdate, Date enddate) throws SQLException {
        return new DBSearchHandler().getPendingReservation(startdate, enddate);
    }

    public boolean acceptResrvation(int id) throws SQLException {
        return new DBReservationHandler().acceptReservation(id);
    }

    public boolean rejectResrvation(int id) throws SQLException {
        return new DBReservationHandler().rejectReservation(id);
    }
}
