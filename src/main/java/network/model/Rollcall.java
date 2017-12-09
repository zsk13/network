package network.model;

import java.util.Date;

public class Rollcall {
    private Long rcId;

    private Long uId;

    private Long rId;

    private Double locationX;

    private Double locationY;

    private String locationName;

    private Date rTime;

    public Long getRcId() {
        return rcId;
    }

    public void setRcId(Long rcId) {
        this.rcId = rcId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Double getLocationX() {
        return locationX;
    }

    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    public Double getLocationY() {
        return locationY;
    }

    public void setLocationY(Double locationY) {
        this.locationY = locationY;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName == null ? null : locationName.trim();
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }
}