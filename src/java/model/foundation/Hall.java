package model.foundation;

import java.util.HashSet;
import java.util.Set;

public class Hall extends Resource {
    
    private Department department;
    private Boolean airConditioned;
    private Boolean projectorAvailable;
    private String boardType;
    
    public Hall() {
    }
    
    public Hall(String resourceid, String category, String resourceName, int capacityAmount, String description, Department department, Boolean airConditioned, Boolean projectorAvailable, String boardType) {
        super(resourceid, category, resourceName, capacityAmount, description);
        this.department = department;
        this.airConditioned = airConditioned;
        this.projectorAvailable = projectorAvailable;
        this.boardType = boardType;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public Boolean isAirConditioned() {
        return airConditioned;
    }
    
    public void setAirConditioned(Boolean airConditioned) {
        this.airConditioned = airConditioned;
    }
    
    public Boolean isProjectorAvailable() {
        return projectorAvailable;
    }
    
    public void setProjectorAvailable(Boolean projectorAvailable) {
        this.projectorAvailable = projectorAvailable;
    }
    
    public String getBoardType() {
        return boardType;
    }
    
    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }
    
}
