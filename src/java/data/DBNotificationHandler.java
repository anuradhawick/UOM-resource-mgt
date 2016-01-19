/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.foundation.Notification;
import model.foundation.Person;

/**
 *
 * @author Anuradha
 */
public class DBNotificationHandler {

    private Connection connection;
    private PreparedStatement statement;

    /*
     Add notification to be seen by a user
     */
    public void addNotification(Notification notif) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO `resource_management`.`notification` (`notification`, `reserve_reserveID`, `person_ID`) VALUES (?, ?, ?);");
        statement.setString(1, notif.getNotification());
        statement.setInt(2, notif.getReservationid());
        statement.setString(3, notif.getPerson_id());
        statement.execute();
        statement.close();
        connection.close();
    }

    /*
     These are request for reservation where the managers are required to see the notification
     thus
     read status = 2 unread for mgr
     acted status = 2 unacted for mgr
     */
    public void addNotificationForMgr(Notification notif) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO `resource_management`.`notification` (`notification`, `read_status`, `acted_status`, `reserve_reserveID`, `person_ID`) VALUES (?, '2', '2', ?, ?)");
        statement.setString(1, notif.getNotification());
        statement.setInt(2, notif.getReservationid());
        statement.setString(3, notif.getPerson_id());
        statement.execute();
        statement.close();
        connection.close();
    }

    /*
     Marking a notification as read for normal users
     */
    public void markNotifRead(Notification not) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("UPDATE notification SET read_status = 1 WHERE idnotification= ?");
        statement.setInt(1, not.getNotif_id());
        statement.execute();
        statement.close();
        connection.close();
    }

    /*
     This is marking a notification to be acted by a manager once acted these are no longer visible
     read status = 3 for mgr
     acted status = 3 for mgr
     */
    public void markNotifActedMgr(Notification not) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("UPDATE notification SET read_status = 3,acted_status = 3 WHERE idnotification=?");
        statement.setInt(1, not.getNotif_id());
        statement.execute();
        statement.close();
        connection.close();
    }
    /*
     get all notif for a particular person
     */

    public ArrayList<Notification> getNotificationsAll(Person p) throws SQLException {
        int notif_id, res_id;
        ArrayList<Notification> arr = new ArrayList<>();
        String notif;
        connection = DBConnector.connect();
        statement = connection.prepareStatement("SELECT idnotification,notification,reserve_reserveID FROM notification n JOIN person p ON n.person_ID = p.ID WHERE p.ID=?");
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            notif_id = set.getInt("idnotification");
            notif = set.getString("notification");
            res_id = set.getInt("reserve_reserveID");
            Notification n = new Notification(notif, p, res_id);
            n.setNotif_id(notif_id);
            arr.add(n);
        }
        statement.close();
        connection.close();
        return arr;
    }

    public ArrayList<Notification> getNotificationsUnread(Person p) throws SQLException {
        int notif_id, res_id;
        ArrayList<Notification> arr = new ArrayList<>();
        String notif;
        connection = DBConnector.connect();
        statement = connection.prepareStatement("SELECT idnotification,notification,reserve_reserveID FROM notification n JOIN person p ON n.person_ID = p.ID WHERE p.ID=? AND n.read_status=0");
        statement.setString(1, p.getId());
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            notif_id = set.getInt("idnotification");
            notif = set.getString("notification");
            res_id = set.getInt("reserve_reserveID");
            Notification n = new Notification(notif, p, res_id);
            n.setNotif_id(notif_id);
            arr.add(n);
        }
        statement.close();
        connection.close();
        return arr;
    }

    /*
     Reading the pending notif for managers
     */
    public ArrayList<Notification> getNotificationsUnreadMgr() throws SQLException {
        int notif_id, res_id;
        ArrayList<Notification> arr = new ArrayList<>();
        String notif;
        connection = DBConnector.connect();
        statement = connection.prepareStatement("SELECT idnotification,notification,reserve_reserveID FROM notification WHERE read_status=2");
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            notif_id = set.getInt("idnotification");
            notif = set.getString("notification");
            res_id = set.getInt("reserve_reserveID");
            Notification n = new Notification(notif, res_id);
            n.setNotif_id(notif_id);
            arr.add(n);
        }
        statement.close();
        connection.close();
        return arr;
    }

    public ArrayList<Notification> getNotificationsUnActedMgr() throws SQLException {
        int notif_id, res_id;
        ArrayList<Notification> arr = new ArrayList<>();
        String notif;
        connection = DBConnector.connect();
        statement = connection.prepareStatement("SELECT idnotification,notification,reserve_reserveID FROM notification WHERE acted_status=0");
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            notif_id = set.getInt("idnotification");
            notif = set.getString("notification");
            res_id = set.getInt("reserve_reserveID");
            Notification n = new Notification(notif, res_id);
            n.setNotif_id(notif_id);
            arr.add(n);
        }
        statement.close();
        connection.close();
        return arr;
    }

    public Notification getNotificationById(int not_id) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("SELECT * FROM notification WHERE idnotification=?");
        statement.setInt(1, not_id);
        ResultSet set = statement.executeQuery();
        Notification n = new Notification();
        if (set.next()) {
            n.setNotif_id(set.getInt("idnotification"));
            n.setNotification(set.getString("notification"));
            n.setReservationid(set.getInt("reserve_reserveID"));
        }
        statement.close();
        connection.close();
        return n;
    }

}
