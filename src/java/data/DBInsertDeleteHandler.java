package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import model.foundation.*;
import org.apache.log4j.Logger;

/**
 *
 * @author Pamoda
 */
public class DBInsertDeleteHandler {
    
    private Connection connection;
    private PreparedStatement statement;

    public void insertAuthorizedPerson(AuthorizedPerson authorizedPerson) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.authorized_person (username , password ,ID) VALUES (?,?,?)");
        statement.setString(1, authorizedPerson.getUsername());
        statement.setString(2, authorizedPerson.getPassword());
        statement.setString(3, authorizedPerson.getId());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertDepartment(Department department) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.department (dept_name ,building ) VALUES (?,?)");
        statement.setString(1, department.getDeptName());
        statement.setString(2, department.getBuilding());
        statement.executeUpdate();
        statement.clearParameters();
    }

    public void insertResource(Resource resource) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.resource (resourceid, resource_name, capacity_amount, description, cat_name) VALUES (?,?,?,?,?)");
        statement.setString(1, resource.getResourceid());
        statement.setString(2, resource.getResourceName());
        statement.setInt(3, resource.getCapacityAmount());
        statement.setString(4, resource.getDescription());
        statement.setString(5, resource.getCategory());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertHall(Hall hall) throws SQLException {
        insertResource(hall);
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.hall (resourceid, air_conditioned, projector_available, board_type, dept_name, building) VALUES (?,?,?,?,?,?)");
        statement.setString(1, hall.getResourceid());
        statement.setBoolean(2, hall.isAirConditioned());
        statement.setBoolean(3, hall.isProjectorAvailable());
        statement.setString(4, hall.getBoardType());
        statement.setString(5, hall.getDepartment().getDeptName());
        statement.setString(6, hall.getDepartment().getBuilding());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertLab(Lab lab) throws SQLException {
        insertResource(lab);
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.lab (air_conditioned, resourceid) VALUES (?,?)");
        statement.setBoolean(1, lab.isAirConditioned());
        statement.setString(2, lab.getResourceid());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertMaintenanceTool(MaintenanceTool maintenanceTool) throws SQLException {
        insertResource(maintenanceTool);
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.maintenance_tool (usage, resourceid) VALUES (?,?)");
        statement.setString(1, maintenanceTool.getUsage());
        statement.setString(2, maintenanceTool.getResourceid());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
        insertResource(maintenanceTool);
    }

    public void insertPerson(Person person) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.person (ID, first_name, middle_name, last_name) VALUES (?,?,?,?)");
        statement.setString(1, person.getId());
        statement.setString(2, person.getFirstName());
        statement.setString(3, person.getMiddleName());
        statement.setString(4, person.getLastName());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertPhone(Phone phone) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.phone (phone_number , person_ID) VALUES (?,?)");
        statement.setString(1, phone.getPhoneNumber());
        statement.setString(2, phone.getPersonId());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertPrivilege(Privilege privilege) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.privilege (priv_name) VALUES (?)");
        statement.setString(1, privilege.getPrivName());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertSportItem(SportItem sportItem) throws SQLException {
        insertResource(sportItem);
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.sport_item (sport , item_number ,resourceid) VALUES (?,?,?)");
        statement.setString(1, sportItem.getSport());
        statement.setString(2, sportItem.getItemNumber());
        statement.setString(3, sportItem.getResourceid());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertSportPlace(SportPlace sportPlace) throws SQLException {
        insertResource(sportPlace);
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.sport_place (location, resourceid) VALUES (?,?)");
        statement.setString(1, sportPlace.getLocation());
        statement.setString(2, sportPlace.getResourceid());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();

    }

    public void insertVehicle(Vehicle vehicle) throws SQLException {
        insertResource(vehicle);
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.vehicle (vehicle_niumber, vehicle_name, facility, resourceid, type)  VALUES (?,?,?,?,?)");
        statement.setString(1, vehicle.getVehicleNumber());
        statement.setString(2, vehicle.getVehicleName());
        statement.setString(3, vehicle.getFacility());
        statement.setString(4, vehicle.getResourceid());
        statement.setString(5, vehicle.getType());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
        connection.close();
    }

    public void insertDailyTimeSlot(DailyTimeSlot dailyTimeSlot) throws SQLException {
        java.sql.Time sqlTime;
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.daily_time_slot (day, start_time, end_time, resourceid) VALUES (?,?,?,?)");
        statement.setString(1, dailyTimeSlot.getDay());
        sqlTime = new java.sql.Time(dailyTimeSlot.getStartTime().getTime());
        statement.setTime(2, sqlTime);
        sqlTime = new java.sql.Time(dailyTimeSlot.getEndTime().getTime());
        statement.setTime(3, sqlTime);
        statement.setString(4, dailyTimeSlot.getResourceid());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertReservation(Reservation reservation) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.reserve (capacity, date_start, date_end,resourceid, ID) VALUES (?,?,?,?,?)");
        statement.setInt(1, reservation.getCapacity());
        statement.setTimestamp(2, new Timestamp(reservation.getStartTime().getTime()));
        statement.setTimestamp(3, new Timestamp(reservation.getEndTime().getTime()));
        statement.setString(4, reservation.getResourceId());
        statement.setString(5, reservation.getPersonId());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();

    }

    public void insertResourceUser(ResourceUser resourceUser) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.resource_user (designation, ID) VALUES (?,?)");
        statement.setString(1, resourceUser.getDesignation());
        statement.setString(2, resourceUser.getId());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertInto_person_priv(Person person, Privilege privilege) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.person_priv (priv_name, ID) VALUES (?,?)");
        statement.setString(1, privilege.getPrivName());
        statement.setString(2, person.getId());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertInto_maintainer(Person person, Hall hall) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.maintainer (resourceid, ID) VALUES (?,?)");
        statement.setString(1, hall.getResourceid());
        statement.setString(2, person.getId());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertInto_driver(Person person, Vehicle vehicle) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.driver (ID, resourceid)  VALUES (?,?)");
        statement.setString(1, person.getId());
        statement.setString(2, vehicle.getResourceid());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }

    public void insertInto_route(Reservation reservation, Vehicle vehicle) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_management.route (reserveID, resourceid)  VALUES (?,?)");
        statement.setInt(1, reservation.getReserveId());
        statement.setString(2, vehicle.getResourceid());
        statement.executeUpdate();
        statement.clearParameters();
        statement.close();
    }
    
    public void deleteReservation(int reservationID) throws SQLException{
        connection = DBConnector.connect();
        statement = connection.prepareStatement("DELETE FROM resource_management.reserve WHERE reserveID=?;");
        statement.setInt(1, reservationID);
        statement.executeUpdate();
    }
}
