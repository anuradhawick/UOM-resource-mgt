package data;

import data.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.foundation.Reservation;

public class DBReservationHandler {

    private Connection connection;
    private PreparedStatement statement;

    public int checkReservation(int resID) throws SQLException {
        int status = 0;
        connection = DBConnector.connect();
        String query = "SELECT approval FROM resource_management.reserve WHERE reserveID=?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, resID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            status = resultSet.getInt("approval");
        }
        statement.close();
        connection.close();
        return status;
    }

    public boolean acceptReservation(int resID) throws SQLException {
        connection = DBConnector.connect();
        String query = "UPDATE resource_management.reserve SET approval=2 WHERE reserveID=?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, resID);
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
        connection.close();
        return true;

    }

    public boolean rejectReservation(int resID) throws SQLException {
        connection = DBConnector.connect();
        String query = "UPDATE resource_management.reserve SET approval=1 WHERE reserveID=?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, resID);
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
        connection.close();
        return true;

    }

    public Reservation getReservstionByID(int id) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("SELECT * FROM reserve WHERE reserveID=?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
         Reservation re=new Reservation();
        while(rs.next()){
        
         re.setReserveId(rs.getInt("reserveID"));
         re.setCapacity(rs.getInt("capacity"));
         re.setApproval(rs.getInt("approval"));
         re.setStartTime(rs.getDate("date_start"));
         re.setEndTime(rs.getDate("date_end"));
         re.setResourceId(rs.getInt("resourceid"));
         re.setPurpose(rs.getString("purpose"));
         re.setPersonId(rs.getString("ID"));
        }
        return re;
    }

}
