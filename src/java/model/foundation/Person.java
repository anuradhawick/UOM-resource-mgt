package model.foundation;

import java.io.InputStream;

public class Person  {

     private String id;
     private String firstName;
     private String middleName;
     private String lastName;
     private InputStream image;
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
    
    /**
     * @return the image
     */
    public InputStream getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(InputStream image) {
        this.image = image;
    }


}


