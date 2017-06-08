package MySpringMVC.dao;

import MySpringMVC.model.Organisation;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrganisationDAOImpl implements OrganisationDAO{
    private JdbcTemplate jdbcTemplate;

    public OrganisationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void saveOrUpdate(Organisation organisation) {
        if (get(organisation.getId()) != null) {
            // update
            String sql = "UPDATE ORGANISATIONS SET ORG_NAME = ?, ACRONYM = ?, CLUS_ID = ? WHERE ORG_ID = ?";
            jdbcTemplate.update(sql, organisation.getName(), organisation.getAcronym(), organisation.getClusId(), organisation.getId());
        } else {
            // insert
            String sql = "INSERT INTO ORGANISATIONS (ORG_ID, CLUS_ID, ORG_NAME, ACRONYM) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, organisation.getId(), organisation.getClusId(), organisation.getName(), organisation.getAcronym());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM ORGANISATIONS WHERE ORG_ID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Organisation get(int id) {
        String sql = "SELECT * FROM ORGANISATIONS WHERE ORG_ID = " + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Organisation>() {

            @Override
            public Organisation extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Organisation contact = new Organisation();
                    contact.setId(rs.getInt("org_id"));
                    contact.setClusId(rs.getInt("clus_id"));
                    contact.setName(rs.getString("org_name"));
                    contact.setAcronym(rs.getString("acronym"));
                    return contact;
                }

                return null;
            }

        });
    }

    @Override
    public List<Organisation> list() {
        String sql = "SELECT * FROM ORGANISATIONS";
        List<Organisation> listOrganisation = jdbcTemplate.query(sql, new RowMapper<Organisation>() {

            @Override
            public Organisation mapRow(ResultSet rs, int rowNum) throws SQLException {
                Organisation aOrganisation = new Organisation();

                aOrganisation.setId(rs.getInt("org_id"));
                aOrganisation.setClusId(rs.getInt("clus_id"));
                aOrganisation.setName(rs.getString("org_name"));
                aOrganisation.setAcronym(rs.getString("acronym"));

                return aOrganisation;
            }

        });

        return listOrganisation;
    }
}
