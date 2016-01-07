package model.foundation;


public class Department {

     private String deptName;
     private String building;

    public Department() {
    }

     
    public Department(String deptName, String building) {
       this.deptName = deptName;
       this.building = building;
    }
   
    public String getDeptName() {
        return this.deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getBuilding() {
        return this.building;
    }
    
    public void setBuilding(String building) {
        this.building = building;
    }

}
  


