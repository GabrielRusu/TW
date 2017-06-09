package MySpringMVC.model;

public class ProjectActivity {

    String cluster;
    String district;
    String municipality;
    String activity;
    String item;
    int total;
    String unit;

    public ProjectActivity() {
    }

    public ProjectActivity(String cluster, String district, String municipality, String activity,
                           String item, int total, String unit) {
        this.cluster = cluster;
        this.district = district;
        this.municipality = municipality;
        this.activity = activity;
        this.item = item;
        this.total = total;
        this.unit = unit;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
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
