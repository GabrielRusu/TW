package MySpringMVC.model;


public class Organisation {

    private int id;
    private int clusId;
    private String name;
    private String acronym;

    public Organisation(){

    }

    public Organisation(int id, int clusId, String name, String acronym) {
        this.id = id;
        this.clusId = clusId;
        this.name = name;
        this.acronym = acronym;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClusId() {
        return clusId;
    }

    public void setClusId(int clusId) {
        this.clusId = clusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
