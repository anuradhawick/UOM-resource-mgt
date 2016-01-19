/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import data.DBPrivilegeUserHandler;
import java.sql.SQLException;
import model.foundation.AuthorizedPerson;
import model.foundation.Person;

/**
 *
 * @author Anuradha
 */
public class anuradha_test {

    public static void main(String[] args) throws SQLException {
//        List<s> ss = new ArrayList<>();
//        ss.add(new s(5, "Anu"));
//        ss.add(new s(6, "rad"));
//        ss.add(new s(7, "has"));
//        ss.add(new s(8, "anj"));
//        Gson g = new Gson();
//        String sss =g.toJson(ss);
//        System.out.println(sss);

//        DBPrivilegeUserHandler dbh = new DBPrivilegeUserHandler();
//            AuthorizedPerson auth = new AuthorizedPerson();
//            auth.setUsername("admin");        
//            Person person = dbh.getLoggedPerson(auth);
//            System.out.println(person.getId());
//            DBNotificationHandler nh = new DBNotificationHandler();
//        ArrayList<Notification> arr = nh.getNotificationsUnread(person);
//        for (Notification n : arr) {
//            System.out.println(n.getNotification());
//        }
//        Gson g = new Gson();
//        System.out.println(g.toJson(new ArrayList<Object>()));
//        AuthorizedPerson p_update = new AuthorizedPerson();
//        p_update.setUsername("admin");
//        Person person_update = (new DBPrivilegeUserHandler()).getLoggedPerson(p_update);
////        System.out.println(Algorithm.ImageEncoder.getImageString(person_update.getImage(),128,128));
//        System.out.println(person_update.getImage()==null);
        AuthorizedPerson p = new AuthorizedPerson();
        p.setUsername("admin");
//            p.setPassword(password);
        DBPrivilegeUserHandler dbh = new DBPrivilegeUserHandler();
        Person per = dbh.getLoggedPerson(p);
//        System.out.println(p.getId());
        per.setFirstName("Anuradha");
        per.setMiddleName("sd");
        per.setLastName("asd");
        System.out.println(dbh.updateDetails(p, per, null));
    }

    static class s {

        int i;
        String m;

        public s(int i, String m) {
            this.i = i;
            this.m = m;
        }
    }
}
