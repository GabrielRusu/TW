package MySpringMVC.dao;

import java.util.List;

import MySpringMVC.model.Population;

public interface PopulationDAO {

    public void saveOrUpdate(Population population);

    public void delete(int mun_id, int dis_id);

    public Population get(int mun_id, int dis_id);

    public List<Population> list();
}
