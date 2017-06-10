package MySpringMVC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import MySpringMVC.model.District;

public class DistrictDAOImpl implements DistrictDAO {

    private JdbcTemplate jdbcTemplate;

    public DistrictDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(District district) {
        if (get(district.getId()) != null) {
            // update
            String sql = "UPDATE districts SET name=? WHERE dis_id=?";
            jdbcTemplate.update(sql, district.getName(), district.getId());
        } else {
            // insert
            String sql = "INSERT INTO districts (dis_id, name) VALUES (?, ?)";
            jdbcTemplate.update(sql, district.getId(), district.getName());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM districts WHERE dis_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<District> list(Integer pageId,int total) {
        String sql = "SELECT * FROM "+
                " ( "
                + "select a.*, rownum r__ FROM" +
                "( "
                + "select * from DISTRICTS " +
                " ) a " +
                " where rownum < "  +((pageId * total) + 1) +
                ") WHERE r__ >= " + (((pageId - 1)* total)+1);
        List<District> listDistrict = jdbcTemplate.query(sql, new RowMapper<District>() {

            @Override
            public District mapRow(ResultSet rs, int rowNum) throws SQLException {
                District aDistrict = new District();

                aDistrict.setId(rs.getInt("dis_id"));
                aDistrict.setName(rs.getString("name"));

                return aDistrict;
            }

        });

        return listDistrict;
    }

    @Override
    public District get(int id) {
        String sql = "SELECT * FROM districts WHERE dis_id = " + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<District>() {

            @Override
            public District extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    District contact = new District();
                    contact.setId(rs.getInt("dis_id"));
                    contact.setName(rs.getString("name"));
                    return contact;
                }

                return null;
            }

        });
    }

}
