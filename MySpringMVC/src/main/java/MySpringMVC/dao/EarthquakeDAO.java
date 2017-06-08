package MySpringMVC.dao;

import MySpringMVC.model.Earthquake;

import java.util.List;

public interface EarthquakeDAO {

    public void saveOrUpdate(Earthquake earthquake);

    public void delete(int id);

    public Earthquake get(int id);

    public List<Earthquake> list();
}
