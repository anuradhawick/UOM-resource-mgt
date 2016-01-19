package model.foundation;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public abstract class Resource {
    
     private int resourceid;
     private String category;
     private String resourceName;
     private int capacityAmount;
     private String description;
     private InputStream image;

    public Resource() {
    }
    
    public Resource(int resourceid, String category, String resourceName, int capacityAmount, String description) {
       this.resourceid = resourceid;
       this.category = category;
       this.resourceName = resourceName;
       this.capacityAmount = capacityAmount;
       this.description = description;
    }
   
    public int getResourceid() {
        return this.resourceid;
    }
    
    public void setResourceid(int resourceid) {
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


