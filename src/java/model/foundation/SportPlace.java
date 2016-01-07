package model.foundation;

public class SportPlace extends Resource {

    private String location;

    public SportPlace() {
    }
    
    
    public SportPlace(String resourceid, String category, String resourceName, int capacityAmount, String description, String location) {
        super(resourceid, category, resourceName, capacityAmount, description);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }  
}
