package MySpringMVC.dao;


import MySpringMVC.model.Project;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {

    private JdbcTemplate jdbcTemplate;

    public ProjectDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Project Project) {
        if (get(Project.getMunId()) != null) {
            // update
            String sql = "UPDATE PROJECTS SET ITEM = ?, TOTAL = ?, UNIT = ? WHERE CLUS_ID = ? AND DIS_ID = ? AND MUN_ID = ? ";
            jdbcTemplate.update(sql, Project.getItem(), Project.getTotal(), Project.getUnit(), Project.getClusId(),
                    Project.getDisId(), Project.getMunId());
        } else {
            // insert
            String sql = "INSERT INTO Projects (CLUS_ID, DIS_ID, MUN_ID, ACTIVITY_TYPE, ITEM, " +
                    "TOTAL, UNIT) VALUES (?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, Project.getClusId(), Project.getDisId(), Project.getMunId(),
                    Project.getActivityType(), Project.getItem(), Project.getTotal(), Project.getUnit());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM PROJECTS WHERE MUN_ID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Project get(int id) {
        String sql = "SELECT * FROM PROJECTS WHERE MUN_ID = " + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Project>() {

            @Override
            public Project extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Project contact = new Project();
                    contact.setClusId(rs.getInt("clus_id"));
                    contact.setMunId(rs.getInt("mun_id"));
                    contact.setDisId(rs.getInt("dis_id"));
                    contact.setActivityType(rs.getString("activity_type"));
                    contact.setItem(rs.getString("item"));
                    contact.setTotal(rs.getInt("total"));
                    contact.setUnit(rs.getString("unit"));
                    return contact;
                }
                return null;
            }

        });
    }

    @Override
    public List<Project> list(Integer pageId,int total) {
        String sql = "SELECT * FROM "+
                " ( "
                + "select a.*, rownum r__ FROM" +
                "( "
                + "select * from PROJECTS " +
                " ) a " +
                " where rownum < "  +((pageId * total) + 1) +
                ") WHERE r__ >= " + (((pageId - 1)* total)+1);

        List<Project> listProject = jdbcTemplate.query(sql, new RowMapper<Project>() {

            @Override
            public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
                Project aProject = new Project();

                aProject.setClusId(rs.getInt("clus_id"));
                aProject.setMunId(rs.getInt("mun_id"));
                aProject.setDisId(rs.getInt("dis_id"));
                aProject.setActivityType(rs.getString("activity_type"));
                aProject.setItem(rs.getString("item"));
                aProject.setTotal(rs.getInt("total"));
                aProject.setUnit(rs.getString("unit"));

                return aProject;
            }

        });

        return listProject;
    }
}
