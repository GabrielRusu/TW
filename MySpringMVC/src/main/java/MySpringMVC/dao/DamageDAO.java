package MySpringMVC.dao;

import MySpringMVC.model.Damage;

import java.util.List;

/**
 * Created by Stefan on 6/8/2017.
 */
public interface DamageDAO {

    public void saveOrUpdate(Damage damage);

    public void delete(int id);

    public Damage get(int id);

    public List<Damage> list();
}
