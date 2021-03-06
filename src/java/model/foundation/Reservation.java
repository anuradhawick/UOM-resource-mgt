package model.foundation;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Reservation {

    private int reserveId;
    private int capacity;
    private Date endTime;
    private Date startTime;
    private int resourceId;
    private String PersonId;
    private int approval;
    private String purpose;
    private Resource resource;
    private Person person;

    public Reservation() {
    }

    public Reservation(int capacity, Date startTime, Date endTime, int resourceId, String PersonId,int approval,String purpose) {
        this.capacity = capacity;
        this.endTime = endTime;
        this.startTime = startTime;
        this.resourceId = resourceId;
        this.PersonId = PersonId;
        this.approval=approval;
        this.purpose=purpose;
    }

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getPersonId() {
        return PersonId;
    }

    public void setPersonId(String PersonId) {
        this.PersonId = PersonId;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPurpose() {
        return purpose;
    }
  
    public int getApproval() {
        return approval;
    }

    public void setApproval(int approval) {
        this.approval = approval;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

   
    public Person getPerson() {
        return person;
    }

   
    public void setPerson(Person person) {
        this.person = person;
    }

}
