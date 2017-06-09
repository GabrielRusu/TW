package MySpringMVC.dao;


import MySpringMVC.model.Project;

import java.util.List;

public interface ProjectDAO {

    public void saveOrUpdate(Project Project);

    public void delete(int id);

    public Project get(int id);

    public List<Project> list(Integer pageId,int total);
}
