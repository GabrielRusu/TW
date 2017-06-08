package MySpringMVC.model;

/**
 * Created by Stefan on 6/8/2017.
 */
public class Damage {

    private int disId;
    private int maleDeath;
    private int femDeath;
    private int maleInjured;
    private int femInjured;
    private int publicDamages;

    public Damage() {

    }
    
    public Damage(int disId, int maleDeath, int femDeath, int maleInjured, int femInjured, int publicDamages) {
        this.disId = disId;
        this.maleDeath = maleDeath;
        this.femDeath = femDeath;
        this.maleInjured = maleInjured;
        this.femInjured = femInjured;
        this.publicDamages = publicDamages;
    }

    public int getDisId() {
        return disId;
    }

    public void setDisId(int disId) {
        this.disId = disId;
    }

    public int getMaleDeath() {
        return maleDeath;
    }

    public void setMaleDeath(int maleDeath) {
        this.maleDeath = maleDeath;
    }

    public int getFemDeath() {
        return femDeath;
    }

    public void setFemDeath(int femDeath) {
        this.femDeath = femDeath;
    }

    public int getMaleInjured() {
        return maleInjured;
    }

    public void setMaleInjured(int maleInjured) {
        this.maleInjured = maleInjured;
    }

    public int getFemInjured() {
        return femInjured;
    }

    public void setFemInjured(int femInjured) {
        this.femInjured = femInjured;
    }

    public int getPublicDamages() {
        return publicDamages;
    }

    public void setPublicDamages(int publicDamages) {
        this.publicDamages = publicDamages;
    }
}
