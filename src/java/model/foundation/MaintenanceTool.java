package model.foundation;

public class MaintenanceTool extends Resource {

    private String usage;

    public MaintenanceTool() {
    }

    public MaintenanceTool(String resourceid, String category, String resourceName, int capacityAmount, String description, MaintenanceTool maintenanceTool, SportItem sportItem, String usage) {
        this.usage = usage;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
}
