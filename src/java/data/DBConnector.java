package data;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Dulaj
 */
public class DBConnector {
    
    private static Logger log = Logger.getLogger(DBConnector.class);

    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Constants.DATABASE_HOST, Constants.DATABASE_USER, Constants.DATABASE_PASSWORD);
            return connection;
        } catch (ClassNotFoundException e) {
            log.error("Unable to find the driver classes: ", e);
            return null;
        } catch (SQLException e) {
            log.error("Unable to access the database server: ", e);
            return null;
        }
    }

    public static void closeDB(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Unable to close the database connection: ", e);
            }
        }
    }
}
