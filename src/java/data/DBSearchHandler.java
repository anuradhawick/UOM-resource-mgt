package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.foundation.Department;
import model.foundation.Hall;
import model.foundation.Lab;
import model.foundation.MaintenanceTool;
import model.foundation.Reservation;
import model.foundation.Resource;
import model.foundation.ResourceView;
import model.foundation.SportItem;
import model.foundation.SportPlace;
import model.foundation.Vehicle;

/**
 *
 * @author RAVIDU-PC
 */
public class DBSearchHandler {

    //return results according to the keyword given
    public ArrayList<Resource> SearchKeyword(String category, int offset, int limit) {
        Connection c = DBConnector.connect();
        try {

            Statement stmt = c.createStatement();
            if (category.equals("Lab")) {
                Connection connection = DBConnector.connect();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM resource INNER JOIN lab USING(resourceid) WHERE cat_name=? LIMIT ?,?");
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, offset);
                preparedStatement.setInt(3, limit);

                ResultSet rs = preparedStatement.executeQuery();
                ArrayList l = new ArrayList();
                while (rs.next()) {

                    Lab lab = new Lab();
                    lab.setResourceid(rs.getString("resourceid"));
                    lab.setCategory(category);
                    lab.setResourceName(rs.getString("resource_name"));
                    lab.setCapacityAmount(rs.getInt("capacity_amount"));
                    lab.setDescription(rs.getString("description"));
                    lab.setAirConditioned(rs.getBoolean("air_conditioned"));

                    Department department = new Department();
                    department.setDeptName(rs.getString("dept_name"));
                    department.setBuilding(rs.getString("building"));
                    lab.setDepartment(department);

                    l.add(lab);
                }

                return l;

            } else if (category.equals("Sport Place")) {

                Connection connection = DBConnector.connect();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM resource INNER JOIN sport_place USING(resourceid) WHERE cat_name=? LIMIT ?,?");
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, offset);
                preparedStatement.setInt(3, limit);

                ResultSet rs = preparedStatement.executeQuery();
                ArrayList p = new ArrayList<>();

                while (rs.next()) {
                    SportPlace sportplace = new SportPlace();
                    sportplace.setResourceid(rs.getString("resourceid"));
                    sportplace.setCategory(category);
                    sportplace.setResourceName(rs.getString("resource_name"));
                    sportplace.setCapacityAmount(rs.getInt("capacity_amount"));
                    sportplace.setDescription(rs.getString("description"));
                    sportplace.setLocation(rs.getString("location"));
                    p.add(sportplace);
                }
                DBConnector.closeDB(c);
                return p;

            } else if (category.equals("Sport Item")) {
                Connection connection = DBConnector.connect();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM resource INNER JOIN sport_item USING(resourceid) WHERE cat_name=? LIMIT ?,?");
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, offset);
                preparedStatement.setInt(3, limit);

                ResultSet rs = preparedStatement.executeQuery();
                ArrayList si = new ArrayList<>();

                while (rs.next()) {
                    SportItem sportitem = new SportItem();
                    sportitem.setResourceid(rs.getString("resourceid"));
                    sportitem.setCategory(category);
                    sportitem.setResourceName(rs.getString("resource_name"));
                    sportitem.setCapacityAmount(rs.getInt("capacity_amount"));
                    sportitem.setDescription(rs.getString("description"));
                    sportitem.setSport(rs.getString("sport"));
                    sportitem.setItemNumber(rs.getString("item_number"));
                    si.add(sportitem);
                }
                return si;

            } else if (category.equals("Maintenance Tool")) {
                Connection connection = DBConnector.connect();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM resource INNER JOIN maintenance_tool USING(resourceid) WHERE cat_name=? LIMIT ?,?");
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, offset);
                preparedStatement.setInt(3, limit);

                ResultSet rs = preparedStatement.executeQuery();
                ArrayList mt = new ArrayList<>();
                while (rs.next()) {
                    MaintenanceTool tool = new MaintenanceTool();
                    tool.setResourceid(rs.getString("resourceid"));
                    tool.setCategory(category);
                    tool.setResourceName(rs.getString("resource_name"));
                    tool.setCapacityAmount(rs.getInt("capacity_amount"));
                    tool.setDescription(rs.getString("description"));
                    tool.setUsage(rs.getString("usage"));

                    mt.add(tool);
                }
                return mt;

            } else if (category.equals("Hall")) {
                Connection connection = DBConnector.connect();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM resource INNER JOIN hall USING(resourceid) WHERE cat_name=? LIMIT ?,?");
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, offset);
                preparedStatement.setInt(3, limit);

                ResultSet rs = preparedStatement.executeQuery();
                ArrayList h = new ArrayList();

                while (rs.next()) {

                    Hall hall = new Hall();
                    hall.setResourceid(rs.getString("resourceid"));
                    hall.setCategory(category);
                    hall.setResourceName(rs.getString("resource_name"));
                    hall.setCapacityAmount(rs.getInt("capacity_amount"));
                    hall.setDescription(rs.getString("description"));
                    hall.setAirConditioned(rs.getBoolean("air_conditioned"));
                    hall.setProjectorAvailable(rs.getBoolean("projector_available"));
                    hall.setBoardType(rs.getString("board_type"));

                    Department d = new Department();
                    d.setDeptName(rs.getString("dept_name"));
                    d.setBuilding(rs.getString("building"));
                    hall.setDepartment(d);

                    h.add(hall);
                }
                return h;

            } else if (category.equals("Vehicle")) {
                Connection connection = DBConnector.connect();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM resource INNER JOIN vehicle USING(resourceid) WHERE cat_name=? LIMIT ?,?");
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, offset);
                preparedStatement.setInt(3, limit);

                ResultSet rs = preparedStatement.executeQuery();
                ArrayList v = new ArrayList<>();

                while (rs.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setResourceid(rs.getString("resourceid"));
                    vehicle.setCategory(category);
                    vehicle.setResourceName(rs.getString("resource_name"));
                    vehicle.setCapacityAmount(rs.getInt("capacity_amount"));
                    vehicle.setDescription(rs.getString("description"));
                    vehicle.setVehicleNumber(rs.getString("vehicle_niumber"));
                    vehicle.setVehicleName(rs.getString("vehicle_name"));
                    vehicle.setFacility(rs.getString("facility"));
                    vehicle.setType(rs.getString("type"));
                    v.add(vehicle);
                }
                return v;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            DBConnector.closeDB(c);
        }

        return null;
    }

    public List<String> searchbyCategory(String word) {
        word = word.trim();
        Connection c = DBConnector.connect();
        try {
            Statement s = c.createStatement();
            String query = "SELECT * FROM category WHERE cat_name LIKE '%" + word + "%'";
            ResultSet rs = s.executeQuery(query);
            DBConnector.closeDB(c);
            ArrayList<String> arr = new ArrayList<>();
            while (rs.next()) {
                arr.add(rs.getString("cat_name"));
            }
            return arr;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBConnector.closeDB(c);
        }
        return null;

    }

    public ArrayList<ResourceView> searchbyCategory(int start, int end) throws SQLException {
        Connection connection = DBConnector.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM RESOURCE LIMIT ?,?");
        preparedStatement.setInt(1, start);
        preparedStatement.setInt(2, end);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<ResourceView> arr = new ArrayList<>();

        while (resultSet.next()) {
            ResourceView rv = new ResourceView();
            rv.setResourceid(resultSet.getString("resourceid"));
            rv.setResourceName(resultSet.getString("resource_name"));
            rv.setCapacityAmount(resultSet.getInt("capacity_amount"));
            rv.setDescription(resultSet.getString("description"));
            rv.setCategory(resultSet.getString("cat_name"));
            arr.add(rv);
        }
        return arr;
    }

    public Resource SearchResource(String category, int id) {
        Connection c = DBConnector.connect();
        try {

            Statement stmt = c.createStatement();
            if (category.equals("Lab")) {
                String query = "SELECT * FROM resource INNER JOIN lab USING(resourceid)"
                        + " INNER JOIN department USING(dept_name)"
                        + "WHERE cat_name=? AND resourceid=?";
                PreparedStatement preparedStatement = c.prepareStatement(query);
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, id);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {

                    Lab lab = new Lab();
                    lab.setResourceid(rs.getString("resourceid"));
                    lab.setCategory(category);
                    lab.setResourceName(rs.getString("resource_name"));
                    lab.setCapacityAmount(rs.getInt("capacity_amount"));
                    lab.setDescription(rs.getString("description"));
                    lab.setAirConditioned(rs.getBoolean("air_conditioned"));

                    Department department = new Department();
                    department.setDeptName(rs.getString("dept_name"));
                    department.setBuilding(rs.getString("building"));
                    lab.setDepartment(department);
                    return lab;

                }

            } else if (category.equals("Sport Place")) {

                String query = "SELECT * FROM resource INNER JOIN sport_place USING(resourceid)"
                        + "WHERE cat_name=? AND resourceid=?";
                PreparedStatement preparedStatement = c.prepareStatement(query);
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, id);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    SportPlace sportplace = new SportPlace();
                    sportplace.setResourceid(rs.getString("resourceid"));
                    sportplace.setCategory(category);
                    sportplace.setResourceName(rs.getString("resource_name"));
                    sportplace.setCapacityAmount(rs.getInt("capacity_amount"));
                    sportplace.setDescription(rs.getString("description"));
                    sportplace.setLocation(rs.getString("location"));
                    return sportplace;
                }

            } else if (category.equals("Sport Item")) {
                String query = "SELECT * FROM resource INNER JOIN sport_item USING(resourceid)"
                        + "WHERE cat_name=? AND resourceid=?";
                PreparedStatement preparedStatement = c.prepareStatement(query);
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    SportItem sportitem = new SportItem();
                    sportitem.setResourceid(rs.getString("resourceid"));
                    sportitem.setCategory(category);
                    sportitem.setResourceName(rs.getString("resource_name"));
                    sportitem.setCapacityAmount(rs.getInt("capacity_amount"));
                    sportitem.setDescription(rs.getString("description"));
                    sportitem.setSport(rs.getString("sport"));
                    sportitem.setItemNumber(rs.getString("item_number"));
                    return sportitem;
                }

            } else if (category.equals("Maintenance Tool")) {

                String query = "SELECT * FROM resource INNER JOIN maintenance_tool USING(resourceid)"
                        + "WHERE cat_name=? AND resourceid=?";
                PreparedStatement preparedStatement = c.prepareStatement(query);
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, id);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    MaintenanceTool tool = new MaintenanceTool();
                    tool.setResourceid(rs.getString("resourceid"));
                    tool.setCategory(category);
                    tool.setResourceName(rs.getString("resource_name"));
                    tool.setCapacityAmount(rs.getInt("capacity_amount"));
                    tool.setDescription(rs.getString("description"));
                    tool.setUsage(rs.getString("usage"));

                    return tool;
                }

            } else if (category.equals("Hall")) {

                String query = "SELECT * FROM resource INNER JOIN hall USING(resourceid)"
                        + " WHERE cat_name=? AND resourceid=?;";
                PreparedStatement preparedStatement = c.prepareStatement(query);
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, id);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {

                    Hall hall = new Hall();
                    hall.setResourceid(rs.getString("resourceid"));
                    hall.setCategory(category);
                    hall.setResourceName(rs.getString("resource_name"));
                    hall.setCapacityAmount(rs.getInt("capacity_amount"));
                    hall.setDescription(rs.getString("description"));
                    hall.setAirConditioned(rs.getBoolean("air_conditioned"));
                    hall.setProjectorAvailable(rs.getBoolean("projector_available"));
                    hall.setBoardType(rs.getString("board_type"));

                    Department d = new Department();
                    d.setDeptName(rs.getString("dept_name"));
                    d.setBuilding(rs.getString("building"));
                    hall.setDepartment(d);

                    return hall;
                }

            } else if (category.equals("Vehicle")) {

                String query = "SELECT * FROM resource INNER JOIN vehicle USING(resourceid)"
                        + " WHERE cat_name=? AND resourceid=?;";
                PreparedStatement preparedStatement = c.prepareStatement(query);
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setResourceid(rs.getString("resourceid"));
                    vehicle.setCategory(category);
                    vehicle.setResourceName(rs.getString("resource_name"));
                    vehicle.setCapacityAmount(rs.getInt("capacity_amount"));
                    vehicle.setDescription(rs.getString("description"));
                    vehicle.setVehicleNumber(rs.getString("vehicle_niumber"));
                    vehicle.setVehicleName(rs.getString("vehicle_name"));
                    vehicle.setFacility(rs.getString("facility"));
                    vehicle.setType(rs.getString("type"));
                    return vehicle;
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnector.closeDB(c);
        }

        return null;
    }

    public ArrayList<Reservation> getApprovedReservationHistory(Date startdate, Date enddate) throws SQLException {
        Connection connection = DBConnector.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM resource_management.reserve WHERE ((DATE(date_start)>=? and DATE(date_start)<=?) and(DATE(date_end)<=?)) and approval=?");
        preparedStatement.setDate(1, new java.sql.Date(startdate.getTime()));
        preparedStatement.setDate(2, new java.sql.Date(enddate.getTime()));
        preparedStatement.setDate(3, new java.sql.Date(enddate.getTime()));
        preparedStatement.setInt(4, 2);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Reservation> list = new ArrayList<>();
        while (resultSet.next()) {
            Reservation rv = new Reservation();
            rv.setReserveId(resultSet.getInt("reserveID"));
            rv.setCapacity(resultSet.getInt("capacity"));
            rv.setStartTime(resultSet.getDate("date_start"));
            rv.setEndTime(resultSet.getDate("date_end"));
            rv.setResourceId(resultSet.getString("resourceid"));
            rv.setPersonId(resultSet.getString("ID"));
            rv.setPurpose(resultSet.getString("purpose"));
            rv.setApproval(resultSet.getInt("approval"));
            list.add(rv);
        }
        return list;
    }

    public ArrayList<Reservation> getRejectedReservationHistory(Date startdate, Date enddate) throws SQLException {
        Connection connection = DBConnector.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM resource_management.reserve WHERE ((DATE(date_start)>=? and DATE(date_start)<=?) and(DATE(date_end)<=?)) and approval=?");
        preparedStatement.setDate(1, new java.sql.Date(startdate.getTime()));
        preparedStatement.setDate(2, new java.sql.Date(enddate.getTime()));
        preparedStatement.setDate(3, new java.sql.Date(enddate.getTime()));
        preparedStatement.setInt(4, 1);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Reservation> list = new ArrayList<>();
        while (resultSet.next()) {
            Reservation rv = new Reservation();
            rv.setReserveId(resultSet.getInt("reserveID"));
            rv.setCapacity(resultSet.getInt("capacity"));
            rv.setStartTime(resultSet.getDate("date_start"));
            rv.setEndTime(resultSet.getDate("date_end"));
            rv.setResourceId(resultSet.getString("resourceid"));
            rv.setPersonId(resultSet.getString("ID"));
            rv.setPurpose(resultSet.getString("purpose"));
            rv.setApproval(resultSet.getInt("approval"));
            list.add(rv);
        }
        return list;
    }
    
    public ArrayList<Reservation> getPendingReservation(Date startdate, Date enddate) throws SQLException {
        Connection connection = DBConnector.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM resource_management.reserve WHERE ((DATE(date_start)>=? and DATE(date_start)<=?) and(DATE(date_end)<=?)) and approval=?");
        preparedStatement.setDate(1, new java.sql.Date(startdate.getTime()));
        preparedStatement.setDate(2, new java.sql.Date(enddate.getTime()));
        preparedStatement.setDate(3, new java.sql.Date(enddate.getTime()));
        preparedStatement.setInt(4, 0);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Reservation> list = new ArrayList<>();
        while (resultSet.next()) {
            Reservation rv = new Reservation();
            rv.setReserveId(resultSet.getInt("reserveID"));
            rv.setCapacity(resultSet.getInt("capacity"));
            rv.setStartTime(resultSet.getDate("date_start"));
            rv.setEndTime(resultSet.getDate("date_end"));
            rv.setResourceId(resultSet.getString("resourceid"));
            rv.setPersonId(resultSet.getString("ID"));
            rv.setPurpose(resultSet.getString("purpose"));
            rv.setApproval(resultSet.getInt("approval"));
            list.add(rv);
        }
        return list;
    }

    public ArrayList<Reservation> getReservationHistory(Date startdate, Date enddate) throws SQLException {
        Connection connection = DBConnector.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM resource_management.reserve WHERE ((DATE(date_start)>=? and DATE(date_start)<=?) and(DATE(date_end)<=?))");
        preparedStatement.setDate(1, new java.sql.Date(startdate.getTime()));
        preparedStatement.setDate(2, new java.sql.Date(enddate.getTime()));
        preparedStatement.setDate(3, new java.sql.Date(enddate.getTime()));

        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Reservation> list = new ArrayList<>();
        while (resultSet.next()) {
            Reservation rv = new Reservation();
            rv.setReserveId(resultSet.getInt("reserveID"));
            rv.setCapacity(resultSet.getInt("capacity"));
            rv.setStartTime(resultSet.getDate("date_start"));
            rv.setEndTime(resultSet.getDate("date_end"));
            rv.setResourceId(resultSet.getString("resourceid"));
            rv.setPersonId(resultSet.getString("ID"));
            rv.setPurpose(resultSet.getString("purpose"));
            rv.setApproval(resultSet.getInt("approval"));
            list.add(rv);
        }
        return list;
    }

}
