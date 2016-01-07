package model.foundation;

import java.util.HashSet;
import java.util.Set;

public class AuthorizedPerson extends Person{
    
     private String username;
     private String password;

    public AuthorizedPerson() {
    }
 
    public AuthorizedPerson(String id, String firstName, String middleName, String lastName, String username, String password) {
        super(id, firstName, middleName, lastName);
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
