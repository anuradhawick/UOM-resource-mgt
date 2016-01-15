/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.foundation;

/**
 *
 * @author Anuradha
 */
public class Notification {

    private String notification;
    private String person_id;
    private int reservationid;
    private int notif_id;

    public Notification() {

    }

    public Notification(String notification, Person person, int reservationids) {
        this.notification = notification;
        this.person_id = person.getId();
        this.reservationid = reservationids;
    }

    /**
     * @return the notification
     */
    public String getNotification() {
        return notification;
    }

    /**
     * @param notification the notification to set
     */
    public void setNotification(String notification) {
        this.notification = notification;
    }

    /**
     * @return the person_id
     */
    public String getPerson_id() {
        return person_id;
    }

    /**
     * @param person_id the person_id to set
     */
    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    /**
     * @return the reservationid
     */
    public int getReservationid() {
        return reservationid;
    }

    /**
     * @param reservationid the reservationid to set
     */
    public void setReservationid(int reservationid) {
        this.reservationid = reservationid;
    }

    /**
     * @return the notif_id
     */
    public int getNotif_id() {
        return notif_id;
    }

    /**
     * @param notif_id the notif_id to set
     */
    public void setNotif_id(int notif_id) {
        this.notif_id = notif_id;
    }

}
