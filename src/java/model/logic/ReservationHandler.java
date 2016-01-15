package model.logic;

import data.DBInsertDeleteHandler;
import data.*;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public boolean addReservation(Reservation reservation) {
        if (isAvailable(reservation.getResourceId(), reservation.getStartTime(), reservation.getEndTime())) {
            try {
                new DBInsertDeleteHandler().insertReservation(reservation);
            } catch (SQLException ex) {
                logger.error("Insert reservation failed", ex);
            }
            return true;
        } else {
            return false;
        }
    }
    
    public void deleteReservation(int reservationID){
        try {
            new DBInsertDeleteHandler().deleteReservation(reservationID);
        } catch (SQLException ex) {
            logger.error("Delete reservation failed", ex);
        }
    }
    
    public boolean modifyReservation(Reservation reservation){
        deleteReservation(reservation.getReserveId());
        return addReservation(reservation);
    }
    
  
}
