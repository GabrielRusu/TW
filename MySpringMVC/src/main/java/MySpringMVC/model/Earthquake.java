package MySpringMVC.model;

/**
 * Created by Stefan on 6/8/2017.
 */
public class Earthquake {

    private int id;
    private int disId;
    private int munId;
    private String date;
    private double hazard;

    public Earthquake(){

    }

    public Earthquake(int id, int disId, int munId, String date, double hazard) {
        this.id = id;
        this.disId = disId;
        this.munId = munId;
        this.date = date;
        this.hazard = hazard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getHazard() {
        return hazard;
    }

    public void setHazard(double hazard) {
        this.hazard = hazard;
    }
}
