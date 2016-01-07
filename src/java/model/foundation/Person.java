package model.foundation;

import java.util.HashSet;
import java.util.Set;

public class Person  {

     private String id;
     private String firstName;
     private String middleName;
     private String lastName;
  /*   private Set halls = new HashSet(0);
     private ResourceUser resourceUser;
     private AuthorizedPerson authorizedPerson;
     private Set reserves = new HashSet(0);
     private Set vehicles = new HashSet(0);
     private Phone phone;*/

    public Person() {
    }

	
    public Person(String id) {
        this.id = id;
    }
    public Person(String id, String firstName, String middleName, String lastName/* Set halls, ResourceUser resourceUser, AuthorizedPerson authorizedPerson, Set reserves, Set vehicles, Phone phone*/) {
       this.id = id;
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
    /*   this.halls = halls;
       this.resourceUser = resourceUser;
       this.authorizedPerson = authorizedPerson;
       this.reserves = reserves;
       this.vehicles = vehicles;
       this.phone = phone;*/
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return this.middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
   /* public Set getHalls() {
        return this.halls;
    }
    
    public void setHalls(Set halls) {
        this.halls = halls;
    }
    public ResourceUser getResourceUser() {
        return this.resourceUser;
    }
    
    public void setResourceUser(ResourceUser resourceUser) {
        this.resourceUser = resourceUser;
    }
    public AuthorizedPerson getAuthorizedPerson() {
        return this.authorizedPerson;
    }
    
    public void setAuthorizedPerson(AuthorizedPerson authorizedPerson) {
        this.authorizedPerson = authorizedPerson;
    }
    public Set getReserves() {
        return this.reserves;
    }
    
    public void setReserves(Set reserves) {
        this.reserves = reserves;
    }
    public Set getVehicles() {
        return this.vehicles;
    }
    
    public void setVehicles(Set vehicles) {
        this.vehicles = vehicles;
    }
    public Phone getPhone() {
        return this.phone;
    }
    
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

*/


}


