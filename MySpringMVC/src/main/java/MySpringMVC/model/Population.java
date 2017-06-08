package MySpringMVC.model;

public class Population {
    private int disId;
    private int munId;
    private int households;
    private int malePop;
    private int fempop;
    private float density;

    public Population() {
    }

    public Population(int disId, int munId, int households, int malePop, int fempop, float density) {
        this.disId = disId;
        this.munId = munId;
        this.households = households;
        this.malePop = malePop;
        this.fempop = fempop;
        this.density = density;
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

    public int getHouseholds() {
        return households;
    }

    public void setHouseholds(int households) {
        this.households = households;
    }

    public int getMalePop() {
        return malePop;
    }

    public void setMalePop(int malePop) {
        this.malePop = malePop;
    }

    public int getFempop() {
        return fempop;
    }

    public void setFempop(int fempop) {
        this.fempop = fempop;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }
}
