package model.foundation;

import java.util.HashSet;
import java.util.Set;

public class Privilege{

     private String privName;
     private Set authorizedPersons = new HashSet(0);

    public Privilege() {
    }

	
    public Privilege(String privName) {
        this.privName = privName;
    }
    public Privilege(String privName, Set authorizedPersons) {
       this.privName = privName;
       this.authorizedPersons = authorizedPersons;
    }
   
    public String getPrivName() {
        return this.privName;
    }
    
    public void setPrivName(String privName) {
        this.privName = privName;
    }
    public Set getAuthorizedPersons() {
        return this.authorizedPersons;
    }
    
    public void setAuthorizedPersons(Set authorizedPersons) {
        this.authorizedPersons = authorizedPersons;
    }




}


