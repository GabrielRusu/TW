package MySpringMVC.dao;


import MySpringMVC.model.Cluster;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClusterDAOImpl implements ClusterDAO {
    private JdbcTemplate jdbcTemplate;

    public ClusterDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Cluster Cluster) {
        if (get(Cluster.getId()) != null) {
            // update
            String sql = "UPDATE Clusters SET name=? WHERE clus_id=?";
            jdbcTemplate.update(sql, Cluster.getName(), Cluster.getId());
        } else {
            // insert
            String sql = "INSERT INTO Clusters (clus_id, name) VALUES (?, ?)";
            jdbcTemplate.update(sql, Cluster.getId(), Cluster.getName());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Clusters WHERE clus_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Cluster> list() {
        String sql = "SELECT * FROM Clusters ORDER BY CLUS_ID";
        List<Cluster> listCluster = jdbcTemplate.query(sql, new RowMapper<Cluster>() {

            @Override
            public Cluster mapRow(ResultSet rs, int rowNum) throws SQLException {
                Cluster aCluster = new Cluster();

                aCluster.setId(rs.getInt("clus_id"));
                aCluster.setName(rs.getString("name"));

                return aCluster;
            }

        });

        return listCluster;
    }

    @Override
    public Cluster get(int id) {
        String sql = "SELECT * FROM Clusters WHERE clus_id = " + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Cluster>() {

            @Override
            public Cluster extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Cluster contact = new Cluster();
                    contact.setId(rs.getInt("clus_id"));
                    contact.setName(rs.getString("name"));
                    return contact;
                }

                return null;
            }

        });
    }
}
