package data;

import static data.DBConnector.connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Dulaj
 */
public class DBSelectHandler {

    private HashMap<Integer, String> day;

    public boolean isAvailable(String resourceID, Date startTime, Date endTime) throws SQLException {
        int counter = 0;
        Connection connection = DBConnector.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(reserveID) as count FROM resource_management.reserve WHERE resourceid=? and ((date_start <= ? and date_end >= ?) or (date_start <= ? and date_end >= ?) or (date_start>=? and date_end<=?));");
        preparedStatement.setString(1, resourceID);
        preparedStatement.setTimestamp(2, new Timestamp(startTime.getTime()));
        preparedStatement.setTimestamp(3, new Timestamp(startTime.getTime()));
        preparedStatement.setTimestamp(4, new Timestamp(endTime.getTime()));
        preparedStatement.setTimestamp(5, new Timestamp(endTime.getTime()));
        preparedStatement.setTimestamp(6, new Timestamp(startTime.getTime()));
        preparedStatement.setTimestamp(7, new Timestamp(endTime.getTime()));
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            if (resultSet.getInt("count") > 0) {
                return false;
            } else {
                ++counter;
            }
        }

        if (counter > 0) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(startTime);
            String dayofweek = getDay(cal.get(Calendar.DAY_OF_WEEK));
            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT count(resourceid) as count FROM resource_management.daily_time_slot WHERE resourceid=? and ((start_time <=? and end_time >=?) or (start_time <=? and end_time >=?) or (date_start>=? and date_end<=?)) and day=?;");
            preparedStatement1.setString(1, resourceID);
            preparedStatement1.setTimestamp(2, new Timestamp(startTime.getTime()));
            preparedStatement1.setTimestamp(3, new Timestamp(startTime.getTime()));
            preparedStatement1.setTimestamp(4, new Timestamp(endTime.getTime()));
            preparedStatement1.setTimestamp(5, new Timestamp(endTime.getTime()));
            preparedStatement.setTimestamp(6, new Timestamp(startTime.getTime()));
            preparedStatement.setTimestamp(7, new Timestamp(endTime.getTime()));
            preparedStatement1.setString(8, dayofweek);
            ResultSet resultSet1 = preparedStatement1.executeQuery();

            while (resultSet1.next()) {
                if (resultSet1.getInt("count") > 0) {
                    return false;

                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public int getResourceCount() throws SQLException {
        Connection connection = DBConnector.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(resourceid) AS resource_count FROM resource");
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            int count = rs.getInt("resource_count");
            return count;
        }
        return 0;
    }

    public int getAvailableItemCount(String resourceID, Date startTime, Date endTime) throws SQLException {
        Connection connection = DBConnector.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(capacity)as count ,resource.capacity_amount,SUM(capacity)as sum_res FROM resource_management.reserve INNER JOIN resource using(resourceid) WHERE resourceid=? and ((date_start <= ? and date_end >= ?) or (date_start <= ? and date_end >= ?) or (date_start>=? and date_end<=?));");
        preparedStatement.setString(1, resourceID);
        preparedStatement.setTimestamp(2, new Timestamp(startTime.getTime()));
        preparedStatement.setTimestamp(3, new Timestamp(startTime.getTime()));
        preparedStatement.setTimestamp(4, new Timestamp(endTime.getTime()));
        preparedStatement.setTimestamp(5, new Timestamp(endTime.getTime()));
        preparedStatement.setTimestamp(6, new Timestamp(startTime.getTime()));
        preparedStatement.setTimestamp(7, new Timestamp(endTime.getTime()));
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            if (resultSet.getInt("count") > 0) {
                return (resultSet.getInt("capacity_amount")-resultSet.getInt("sum_res"));
            } else {
                return resultSet.getInt("capacity_amount");
            }
        }
        return -1;
    }

    private String getDay(int number) {
        if (null == day) {

            day = new HashMap<>();
            day.put(1, "Sunday");
            day.put(2, "Monday");
            day.put(3, "Tuesday");
            day.put(4, "Wednesday");
            day.put(5, "Thursday");
            day.put(6, "Friday");
            day.put(7, "Saturday");
        }
        return day.get(number);
    }
}
