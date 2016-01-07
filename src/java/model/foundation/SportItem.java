package model.foundation;

public class SportItem extends Resource {
    
    private String sport;
    private String itemNumber;
    
    public SportItem() {
    }
    
    public SportItem(String resourceid, String category, String resourceName, int capacityAmount, String description, String sport, String itemNumber) {
        super(resourceid, category, resourceName, capacityAmount, description);
        this.sport = sport;
        this.itemNumber = itemNumber;
    }
    
    public String getSport() {
        return sport;
    }
    
    public void setSport(String sport) {
        this.sport = sport;
    }
    
    public String getItemNumber() {
        return itemNumber;
    }
    
    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }
    
}
