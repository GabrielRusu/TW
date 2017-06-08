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

public class ChartViewDAOImpl {

    private JdbcTemplate jdbcTemplate;

    public ChartViewDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<District> list() {
        String sql = "SELECT * FROM districts order by name";
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
