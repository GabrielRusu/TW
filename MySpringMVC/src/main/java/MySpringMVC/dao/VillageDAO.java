package MySpringMVC.dao;

import MySpringMVC.model.Village;

import java.util.List;

/**
 * Created by Stefan on 6/7/2017.
 */
public interface VillageDAO {

    public void saveOrUpdate(Village village);

    public void delete(int id);

    public Village get(int id);

    public List<Village> list();
}
