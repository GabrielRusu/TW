package MySpringMVC.model;


public class MapInfo {

    private Integer id;
    private String name;
    private String timeStamp;
    private Double hazard;
    private String coord1;
    private String coord2;

    public MapInfo() {
    }

    public MapInfo(Integer id, String name, String timeStamp, Double hazard, String coord1, String coord2) {
        this.id = id;
        this.name = name;
        this.timeStamp = timeStamp;
        this.hazard = hazard;
        this.coord1 = coord1;
        this.coord2 = coord2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Double getHazard() {
        return hazard;
    }

    public void setHazard(Double hazard) {
        this.hazard = hazard;
    }

    public String getCoord1() {
        return coord1;
    }

    public void setCoord1(String coord1) {
        this.coord1 = coord1;
    }

    public String getCoord2() {
        return coord2;
    }

    public void setCoord2(String coord2) {
        this.coord2 = coord2;
    }
}
