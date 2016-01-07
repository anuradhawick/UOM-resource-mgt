package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.foundation.Department;
import model.foundation.Hall;
import model.foundation.Lab;
import model.foundation.MaintenanceTool;
import model.foundation.SportItem;
import model.foundation.SportPlace;
import model.foundation.Vehicle;

/**
 *
 * @author RAVIDU-PC
 */
public class DBSearchHandler {

    //return results according to the keyword given
    public List SearchKeyword(String category) {
        Connection c = DBConnector.connect();
        try {

            Statement stmt = c.createStatement();
            if (category.equals("Lab")) {
                String query = "SELECT * FROM resource INNER JOIN lab USING(resourceid)"
                        + " INNER JOIN department USING(dept_name)"
                        + "WHERE cat_name='" + category + "'";
                ResultSet rs = stmt.executeQuery(query);
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
                DBConnector.closeDB(c);
                return l;

            } else if (category.equals("Sport Place")) {
                ArrayList<SportPlace> p = new ArrayList<>();
                String query = "SELECT * FROM resource INNER JOIN sport_place USING(resourceid)"
                        + "WHERE cat_name='" + category + "'";
                ResultSet rs = stmt.executeQuery(query);
                DBConnector.closeDB(c);
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
                return p;

            } else if (category.equals("Sport Item")) {
                String query = "SELECT * FROM resource INNER JOIN sport_item USING(resourceid)"
                        + "WHERE cat_name='" + category + "'";
                ResultSet rs = stmt.executeQuery(query);
                DBConnector.closeDB(c);
                ArrayList<SportItem> si = new ArrayList<>();
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

                String query = "SELECT * FROM resource INNER JOIN maintenance_tool USING(resourceid)"
                        + "WHERE cat_name='" + category + "'";
                ResultSet rs = stmt.executeQuery(query);
                DBConnector.closeDB(c);
                ArrayList<MaintenanceTool> mt = new ArrayList<>();
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

                String query = "SELECT * FROM resource INNER JOIN hall USING(resourceid)"
                        + " INNER JOIN department USING(dept_name)"
                        + "WHERE cat_name='" + category + "'";
                ResultSet rs = stmt.executeQuery(query);
                DBConnector.closeDB(c);
                ArrayList<Hall> h = new ArrayList<Hall>();
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

                String query = "SELECT * FROM resource INNER JOIN vehicle USING(resourceid)"
                        + "INNER JOIN vehicle_type USING(type) WHERE cat_name='" + category + "'";
                ResultSet rs = stmt.executeQuery(query);
                DBConnector.closeDB(c);
                ArrayList<Vehicle> v = new ArrayList<>();

                while (rs.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setResourceid(rs.getString("resourceid"));
                    vehicle.setCategory(category);
                    vehicle.setResourceName(rs.getString("resource_name"));
                    vehicle.setCapacityAmount(rs.getInt("capacity_amount"));
                    vehicle.setDescription(rs.getString("description"));
                    vehicle.setVehicleNumber(rs.getString("vehicle_number"));
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

}
