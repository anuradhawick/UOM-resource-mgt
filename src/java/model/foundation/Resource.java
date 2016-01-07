package model.foundation;

import java.util.HashSet;
import java.util.Set;

public abstract class Resource {
    
     private String resourceid;
     private String category;
     private String resourceName;
     private int capacityAmount;
     private String description;

    public Resource() {
    }
    
    public Resource(String resourceid, String category, String resourceName, int capacityAmount, String description) {
       this.resourceid = resourceid;
       this.category = category;
       this.resourceName = resourceName;
       this.capacityAmount = capacityAmount;
       this.description = description;
    }
   
    public String getResourceid() {
        return this.resourceid;
    }
    
    public void setResourceid(String resourceid) {
        this.resourceid = resourceid;
    }
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public String getResourceName() {
        return this.resourceName;
    }
    
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    public Integer getCapacityAmount() {
        return this.capacityAmount;
    }
    
    public void setCapacityAmount(Integer capacityAmount) {
        this.capacityAmount = capacityAmount;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}


