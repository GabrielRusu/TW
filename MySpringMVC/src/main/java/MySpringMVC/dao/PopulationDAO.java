package MySpringMVC.dao;

import java.util.List;

import MySpringMVC.model.Population;

public interface PopulationDAO {

    public void saveOrUpdate(Population population);

    public void delete(int id);

    public Population get(int id);

    public List<Population> list();
}
