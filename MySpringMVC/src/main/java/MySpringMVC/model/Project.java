package MySpringMVC.model;

public class Project {
    private int clusId;
    private int disId;
    private int munId;
    private String activityType;
    private String item;
    private int total;
    private String unit;

    public Project(){

    }

    public Project(int clusId, int disId, int munId, String activityType, String item, int total, String unit) {
        this.clusId = clusId;
        this.disId = disId;
        this.munId = munId;
        this.activityType = activityType;
        this.item = item;
        this.total = total;
        this.unit = unit;
    }

    public int getClusId() {
        return clusId;
    }

    public void setClusId(int clusId) {
        this.clusId = clusId;
    }

    public int getDisId() {
        return disId;
    }

    public void setDisId(int disId) {
        this.disId = disId;
    }

    public int getMunId() {
        return munId;
    }

    public void setMunId(int munId) {
        this.munId = munId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
