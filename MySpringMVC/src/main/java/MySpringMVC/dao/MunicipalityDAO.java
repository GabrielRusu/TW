package MySpringMVC.dao;

import MySpringMVC.model.Municipality;

import java.util.List;

public interface MunicipalityDAO {

    public void saveOrUpdate(Municipality municipality);

    public void delete(int id);

    public Municipality get(int id);

    public List<Municipality> list(Integer pageId,int total);
}
