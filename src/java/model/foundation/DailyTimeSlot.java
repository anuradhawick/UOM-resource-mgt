package model.foundation;

import java.util.Date;

public class DailyTimeSlot {

    private String resourceid;
    private String day;
    private Date startTime;
    private Date endTime;

    public DailyTimeSlot() {
    }

    public DailyTimeSlot(String day, Date startTime, Date endTime) {

        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getResourceid() {
        return this.resourceid;
    }

    public void setResourceid(String resourceid) {
        this.resourceid = resourceid;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
