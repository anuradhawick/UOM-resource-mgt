package data;


import data.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    public void acceptReservation(int resID) throws SQLException{
        connection = DBConnector.connect();
        String query= "UPDATE resource_management.reserve SET approval=2 WHERE reserveID=?";            
            statement = connection.prepareStatement(query);
            statement.setInt(1,resID);
            statement.executeUpdate();
            statement.clearParameters();
            statement.close();
            connection.close();
            
    }
        
    public void rejectReservation(int resID) throws SQLException{
        connection = DBConnector.connect();
        String query= "UPDATE resource_management.reserve SET approval=1 WHERE reserveID=?";            
            statement = connection.prepareStatement(query);
            statement.setInt(1,resID);
            statement.executeUpdate();
            statement.clearParameters();
            statement.close();
            connection.close();
            
    }

}