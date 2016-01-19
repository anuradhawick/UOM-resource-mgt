/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.foundation;

/**
 *
 * @author RAVIDU-PC
 */
public class Route {
    
    private int resourceid;
    private int reserveid;
    private String start;
    private String end;

    public Route() {
        
    }

    public Route(int resourceid, int reserveid, String start, String end) {
        this.resourceid = resourceid;
        this.reserveid = reserveid;
        this.start = start;
        this.end = end;
    }
    
    

    
    public int getResourceid() {
        return resourceid;
    }

    public void setResourceid(int resourceid) {
        this.resourceid = resourceid;
    }

    public int getReserveid() {
        return reserveid;
    }

   
    public void setReserveid(int reserveid) {
        this.reserveid = reserveid;
    }

   
    public String getStart() {
        return start;
    }

 
    public void setStart(String start) {
        this.start = start;
    }

    
    public String getEnd() {
        return end;
    }

   
    public void setEnd(String end) {
        this.end = end;
    }
    
}
