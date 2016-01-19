package model.foundation;

import java.util.HashSet;
import java.util.Set;

public class Vehicle extends Resource{

     private String vehicleNumber;
     private String vehicleName;
     private String facility;
     private String type;
     

    public Vehicle() {
    }

    public Vehicle(int resourceid, String category, String resourceName, int capacityAmount, String description, String vehicleNumber, String vehicleName, String facility, String type) {
       super(resourceid, category, resourceName, capacityAmount, description);
       this.vehicleNumber = vehicleNumber;
       this.vehicleName = vehicleName;
       this.facility = facility;
       this.type=type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


