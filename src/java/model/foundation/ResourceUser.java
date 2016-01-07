package model.foundation;

public class ResourceUser extends Person{

    private String id;
    private String designation;

    public ResourceUser() {
    }

   

    public ResourceUser(String id, String firstName, String middleName, String lastName, String designation) {
        super(id, firstName,middleName, lastName);
        this.designation = designation;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}
