package MySpringMVC.dao;

import java.util.List;

import MySpringMVC.model.District;

public interface DistrictDAO {

    public void saveOrUpdate(District district);

    public void delete(int id);

    public District get(int id);

    public List<District> list();
}
