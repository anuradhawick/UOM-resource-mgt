package model.foundation;

public class Lab extends Resource {
    
    private Boolean airConditioned;
    private Department department;
    
    public Lab() {
    }
    
    public Lab(String resourceid, String category, String resourceName, int capacityAmount, String description, boolean airConditioned,Department department) {
        super(resourceid, category, resourceName, capacityAmount, description);
        this.airConditioned = airConditioned;
        this.department=department;
    }
    
    public Boolean isAirConditioned() {
        return airConditioned;
    }
    
    public void setAirConditioned(Boolean airConditioned) {
        this.airConditioned = airConditioned;
    }

   
    public Department getDepartment() {
        return department;
    }

   
    public void setDepartment(Department department) {
        this.department = department;
    }
    
}
