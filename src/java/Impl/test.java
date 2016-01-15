/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import data.DBNotificationHandler;
import data.DBPrivilegeUserHandler;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import model.foundation.AuthorizedPerson;
import model.foundation.Notification;
import model.foundation.Person;
import model.foundation.Privilege;
import model.foundation.Reservation;

/**
 *
 * @author RAVIDU-PC
 */
public class test {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {
        DBNotificationHandler db = new DBNotificationHandler();
        Person p = new Person("130647R");
        Reservation r = new Reservation();
        r.setReserveId(1);
        db.markNotifActedMgr(p, r);
    }

}
