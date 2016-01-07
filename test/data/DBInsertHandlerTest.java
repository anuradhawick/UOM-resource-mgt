package data;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import model.foundation.AuthorizedPerson;
import model.foundation.DailyTimeSlot;
import model.foundation.Department;
import model.foundation.Hall;
import model.foundation.Lab;
import model.foundation.MaintenanceTool;
import model.foundation.Person;
import model.foundation.Phone;
import model.foundation.Privilege;
import model.foundation.Reservation;
import model.foundation.Resource;
import model.foundation.ResourceUser;
import model.foundation.SportItem;
import model.foundation.SportPlace;
import model.foundation.Vehicle;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dulaj
 */
public class DBInsertHandlerTest {
//
//    @Test
//    public void testInsertAuthorizedPerson() throws Exception {
//        System.out.println("insertAuthorizedPerson");
//        AuthorizedPerson authorizedPerson = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertAuthorizedPerson(authorizedPerson);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertDepartment() throws Exception {
//        System.out.println("insertDepartment");
//        Department department = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertDepartment(department);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertResource() throws Exception {
//        System.out.println("insertResource");
//        Resource resource = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertResource(resource);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertHall() throws Exception {
//        System.out.println("insertHall");
//        Hall hall = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertHall(hall);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertLab() throws Exception {
//        System.out.println("insertLab");
//        Lab lab = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertLab(lab);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertMaintenanceTool() throws Exception {
//        System.out.println("insertMaintenanceTool");
//        MaintenanceTool maintenanceTool = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertMaintenanceTool(maintenanceTool);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertPerson() throws Exception {
//        System.out.println("insertPerson");
//        Person person = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertPerson(person);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertPhone() throws Exception {
//        System.out.println("insertPhone");
//        Phone phone = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertPhone(phone);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertPrivilege() throws Exception {
//        System.out.println("insertPrivilege");
//        Privilege privilege = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertPrivilege(privilege);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertSportItem() throws Exception {
//        System.out.println("insertSportItem");
//        SportItem sportItem = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertSportItem(sportItem);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertSportPlace() throws Exception {
//        System.out.println("insertSportPlace");
//        SportPlace sportPlace = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertSportPlace(sportPlace);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertVehicle() throws Exception {
//        System.out.println("insertVehicle");
//        Vehicle vehicle = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertVehicle(vehicle);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertDailyTimeSlot() throws Exception {
//        System.out.println("insertDailyTimeSlot");
//        DailyTimeSlot dailyTimeSlot = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertDailyTimeSlot(dailyTimeSlot);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    @Test
    public void testInsertReservation() {
//        System.out.println("insertReservation");
        Date date = Calendar.getInstance().getTime();
        Reservation reservation = new Reservation(100, date, date, "10001", "130047D");
        
        try {
            DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
            instance.insertReservation(reservation);
        } catch (SQLException ex) {
            fail();
        }
    }
    
//    
//    @Test
//    public void testInsertResourceUser() throws Exception {
//        System.out.println("insertResourceUser");
//        ResourceUser resourceUser = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertResourceUser(resourceUser);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertInto_person_priv() throws Exception {
//        System.out.println("insertInto_person_priv");
//        Person person = null;
//        Privilege privilege = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertInto_person_priv(person, privilege);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertInto_maintainer() throws Exception {
//        System.out.println("insertInto_maintainer");
//        Person person = null;
//        Hall hall = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertInto_maintainer(person, hall);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertInto_driver() throws Exception {
//        System.out.println("insertInto_driver");
//        Person person = null;
//        Vehicle vehicle = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertInto_driver(person, vehicle);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testInsertInto_route() throws Exception {
//        System.out.println("insertInto_route");
//        Reservation reservation = null;
//        Vehicle vehicle = null;
//        DBInsertHandler instance = new DBInsertHandler();
//        instance.insertInto_route(reservation, vehicle);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
