package MySpringMVC.model;

public class Village {

    private int id;
    private int disId;
    private int munId;
    private String name;

    public Village(){
    }

    public Village(int id, int disId, int munId, String name) {
        this.id = id;
        this.disId = disId;
        this.munId = munId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
