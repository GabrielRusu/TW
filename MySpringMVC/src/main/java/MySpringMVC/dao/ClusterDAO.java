package MySpringMVC.dao;
import MySpringMVC.model.Cluster;
import java.util.List;

public interface ClusterDAO {

    public void saveOrUpdate(Cluster Cluster);

    public void delete(int id);

    public Cluster get(int id);

    public List<Cluster> list();
}
