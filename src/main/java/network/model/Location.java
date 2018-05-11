package network.model;

public class Location {
    private Long lId;
    private String locationName;
    private Double minLcationX;
    private Double minLcationY;
    private Double maxLcationX;
    private Double maxLocationY;
    public Long getlId() {
        return lId;
    }
    public void setlId(Long lId) {
        this.lId = lId;
    }
    public String getLocationName() {
        return locationName;
    }
    public void setLocationName(String locationName) {
        this.locationName = locationName == null ? null : locationName.trim();
    }
    public Double getMinLcationX() {
        return minLcationX;
    }
    public void setMinLcationX(Double minLcationX) {
        this.minLcationX = minLcationX;
    }
    public Double getMinLcationY() {
        return minLcationY;
    }
    public void setMinLcationY(Double minLcationY) {
        this.minLcationY = minLcationY;
    }
    public Double getMaxLcationX() {
        return maxLcationX;
    }
    public void setMaxLcationX(Double maxLcationX) {
        this.maxLcationX = maxLcationX;
    }
    public Double getMaxLocationY() {
        return maxLocationY;
    }
    public void setMaxLocationY(Double maxLocationY) {
        this.maxLocationY = maxLocationY;
    }
}