package MySpringMVC.dao;

import MySpringMVC.model.Municipality;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MunicipalityDAOImpl implements MunicipalityDAO {

    private JdbcTemplate jdbcTemplate;

    public MunicipalityDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void saveOrUpdate(Municipality municipality) {
        if (get(municipality.getId()) != null) {
            // update
            String sql = "UPDATE municipalities SET NAME = ?, DIS_ID = ? WHERE MUN_ID = ?";
            jdbcTemplate.update(sql, municipality.getName(), municipality.getDisId(), municipality.getId());
        } else {
            // insert
            String sql = "INSERT INTO municipalities(MUN_ID, DIS_ID, NAME) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, municipality.getId(), municipality.getDisId(), municipality.getName());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM MUNICIPALITIES WHERE mun_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Municipality get(int id) {
        String sql = "SELECT * FROM MUNICIPALITIES WHERE MUN_ID = " + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Municipality>() {

            @Override
            public Municipality extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Municipality contact = new Municipality();
                    contact.setId(rs.getInt("mun_id"));
                    contact.setDisId(rs.getInt("dis_id"));
                    contact.setName(rs.getString("name"));
                    return contact;
                }

                return null;
            }

        });
    }

    @Override
    public List<Municipality> list() {
        String sql = "SELECT * FROM Municipalities order by name";
        List<Municipality> listMunicipality = jdbcTemplate.query(sql, new RowMapper<Municipality>() {

            @Override
            public Municipality mapRow(ResultSet rs, int rowNum) throws SQLException {
                Municipality aMunicipality = new Municipality();

                aMunicipality.setId(rs.getInt("mun_id"));
                aMunicipality.setDisId(rs.getInt("dis_id"));
                aMunicipality.setName(rs.getString("name"));

                return aMunicipality;
            }

        });

        return listMunicipality;
    }
}
