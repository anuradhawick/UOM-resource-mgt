package data;

import static data.DBConnector.connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


/**
 *
 * @author Dulaj
 */
public class DBSelectHandler {

    public boolean isAvailable(String resourceID,Date startTime, Date endTime) throws SQLException {
        Connection connection = DBConnector.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(reserveID) as count FROM resource_management.reserve WHERE resourceid=? and ((date_start <= ? and date_end >= ?) or (date_start <= ? and date_end >= ?));");
        preparedStatement.setString(1, resourceID);
        preparedStatement.setTimestamp(2, new Timestamp(startTime.getTime()));
        preparedStatement.setTimestamp(3, new Timestamp(startTime.getTime()));
        preparedStatement.setTimestamp(4, new Timestamp(endTime.getTime()));
        preparedStatement.setTimestamp(5, new Timestamp(endTime.getTime()));
       
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            if (resultSet.getInt("count") > 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    
    public int getResourceCount() throws SQLException{
        Connection connection = DBConnector.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(resourceid) AS resource_count FROM resource");
        ResultSet rs=preparedStatement.executeQuery();
        if(rs.next()){
            int count=rs.getInt("resource_count");
            return count;
        }
        return 0;
    }
}
