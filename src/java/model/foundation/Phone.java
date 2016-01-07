package model.foundation;

public class Phone  {

     private String personId;
     private String phoneNumber;

    public Phone() {
    }
    
    public Phone(String personID, String phoneNumber) {
        this.personId=personID;
        this.phoneNumber = phoneNumber;
    }
   
    public String getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


