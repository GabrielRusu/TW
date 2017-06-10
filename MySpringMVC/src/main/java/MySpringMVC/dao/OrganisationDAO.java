package MySpringMVC.dao;

import MySpringMVC.model.Organisation;

import java.util.List;


public interface OrganisationDAO {

    public void saveOrUpdate(Organisation Organisation);

    public void delete(int id);

    public Organisation get(int id);

    public List<Organisation> list(Integer pageId,int total);
}
