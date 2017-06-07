package MySpringMVC.model;

public class Municipality {

    private int id;
    private int disId;
    private String name;

    public Municipality(){
    }

    public Municipality(int id, int disId, String name){
        this.id = id;
        this.disId = disId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
