/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.InputStream;
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
import model.foundation.Route;
import model.foundation.SportItem;
import model.foundation.SportPlace;
import model.foundation.Vehicle;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anuradha
 */
public class DBInsertDeleteHandlerTest {
    
    public DBInsertDeleteHandlerTest() {
    }

    @Test
    public void testInsertAuthorizedPerson() throws Exception {
        System.out.println("insertAuthorizedPerson");
        AuthorizedPerson authorizedPerson = new AuthorizedPerson();
        authorizedPerson.setId("130634E");
        authorizedPerson.setUsername("admin");
        authorizedPerson.setPassword("admin");
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertAuthorizedPerson(authorizedPerson);
    }

    @Test
    public void testInsertDepartment() throws Exception {
        System.out.println("insertDepartment");
        Department department = new Department();
        department.setDeptName("CSE");
        department.setBuilding("Sumanadasa building");
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertDepartment(department);
    }

    @Test
    public void testInsertResource() throws Exception {
        System.out.println("insertResource");
        Resource resource = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        int expResult = 0;
        int result = instance.insertResource(resource);
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertHall() throws Exception {
        System.out.println("insertHall");
        Department department = new Department();
        department.setDeptName("CSE");
        department.setBuilding("Sumanadasa building");
        Hall hall = new Hall();
        hall.setResourceid(10);
        hall.setResourceName("Auditorium");
        hall.setAirConditioned(Boolean.TRUE);
        hall.setBoardType("N/A");
        hall.setCapacityAmount(150);
        hall.setCategory("Hall");
        hall.setDepartment(department);
        hall.setDescription("assembly hall");
        hall.setImage(null);
        hall.setProjectorAvailable(Boolean.TRUE);
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertHall(hall);
    }

    @Test
    public void testInsertLab() throws Exception {
        System.out.println("insertLab");
        Lab lab = new Lab();
        Department department = new Department();
        department.setDeptName("CSE");
        department.setBuilding("Sumanadasa building");
        lab.setAirConditioned(Boolean.TRUE);
        lab.setCapacityAmount(10);
        lab.setCategory("Lab");
        lab.setDepartment(department);
        lab.setDescription("new lab");
        lab.setImage(null);
        lab.setResourceName("Lab");
        lab.setResourceid(11);
        
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertLab(lab);
    }

    @Test
    public void testInsertMaintenanceTool() throws Exception {
        System.out.println("insertMaintenanceTool");
        MaintenanceTool maintenanceTool = new MaintenanceTool();
        maintenanceTool.setCapacityAmount(12);
        maintenanceTool.setCategory("maintainance tool");
        maintenanceTool.setDescription("my maintainance tool");
        maintenanceTool.setImage(null);
        maintenanceTool.setResourceName("new maintainance tool");
        maintenanceTool.setResourceid(143);
        maintenanceTool.setUsage("maintain");
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertMaintenanceTool(maintenanceTool);
    }

    @Test
    public void testInsertPerson() throws Exception {
        System.out.println("insertPerson");
        Person person = new Person();
        person.setId("130678E");
        person.setFirstName("Pamoda");
        person.setMiddleName("Anjulie");
        person.setLastName("Wimalasiri");
        person.setImage(null);
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertPerson(person);
    }

    @Test
    public void testInsertPhone() throws Exception {
        System.out.println("insertPhone");
        Phone phone = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertPhone(phone);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertPrivilege() throws Exception {
        System.out.println("insertPrivilege");
        Privilege privilege = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertPrivilege(privilege);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertSportItem() throws Exception {
        System.out.println("insertSportItem");
        SportItem sportItem = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertSportItem(sportItem);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertSportPlace() throws Exception {
        System.out.println("insertSportPlace");
        SportPlace sportPlace = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertSportPlace(sportPlace);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertVehicle() throws Exception {
        System.out.println("insertVehicle");
        Vehicle vehicle = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertVehicle(vehicle);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertDailyTimeSlot() throws Exception {
        System.out.println("insertDailyTimeSlot");
        DailyTimeSlot dailyTimeSlot = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertDailyTimeSlot(dailyTimeSlot);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertReservation() throws Exception {
        System.out.println("insertReservation");
        Reservation reservation = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        int expResult = 0;
        int result = instance.insertReservation(reservation);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertResourceUser() throws Exception {
        System.out.println("insertResourceUser");
        ResourceUser resourceUser = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertResourceUser(resourceUser);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertInto_person_priv() throws Exception {
        System.out.println("insertInto_person_priv");
        Person person = null;
        Privilege privilege = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertInto_person_priv(person, privilege);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertInto_maintainer() throws Exception {
        System.out.println("insertInto_maintainer");
        Person person = null;
        Hall hall = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertInto_maintainer(person, hall);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertInto_driver() throws Exception {
        System.out.println("insertInto_driver");
        Person person = null;
        Vehicle vehicle = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertInto_driver(person, vehicle);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertInto_route() throws Exception {
        System.out.println("insertInto_route");
        Reservation reservation = null;
        Vehicle vehicle = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertInto_route(reservation, vehicle);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteReservation() throws Exception {
        System.out.println("deleteReservation");
        int reservationID = 0;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.deleteReservation(reservationID);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertRoute() throws Exception {
        System.out.println("insertRoute");
        Route route = null;
        DBInsertDeleteHandler instance = new DBInsertDeleteHandler();
        instance.insertRoute(route);
        fail("The test case is a prototype.");
    }
    
}
