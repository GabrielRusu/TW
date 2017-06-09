package MySpringMVC.model;


public class PopStatistics {

    private String name;
    private int population;
    private int dead;
    private int injured;

    public PopStatistics() {
    }

    public PopStatistics(String name, int population, int dead, int injured) {
        this.name = name;
        this.population = population;
        this.dead = dead;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    public int getInjured() {
        return injured;
    }

    public void setInjured(int injured) {
        this.injured = injured;
    }
}
