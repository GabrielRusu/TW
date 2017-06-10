package MySpringMVC.dao;


import MySpringMVC.model.Earthquake;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import sun.security.krb5.internal.EncAPRepPart;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EarthquakeDAOImpl implements EarthquakeDAO {

    private JdbcTemplate jdbcTemplate;

    public EarthquakeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void saveOrUpdate(Earthquake earthquake) {
        if (get(earthquake.getId()) != null) {
            // update
            String sql = "UPDATE Earthquakes SET HAZARD = ?, MUN_ID = ?, DIS_ID = ? WHERE QUAKE_ID = ?";
            jdbcTemplate.update(sql, earthquake.getHazard(), earthquake.getMunId(), earthquake.getDisId(), earthquake.getId());
        } else {
            // insert
            String sql = "INSERT INTO EARTHQUAKES (QUAKE_ID, DIS_ID, MUN_ID, TIME_STAMP, HAZARD) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, earthquake.getId(), earthquake.getDisId(), earthquake.getMunId(),
                    earthquake.getDate(), earthquake.getHazard());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM EARTHQUAKES WHERE QUAKE_ID=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Earthquake get(int id) {
        String sql = "SELECT * FROM EARTHQUAKES WHERE QUAKE_ID = " + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Earthquake>() {

            @Override
            public Earthquake extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Earthquake contact = new Earthquake();
                    contact.setId(rs.getInt("quake_id"));
                    contact.setDisId(rs.getInt("dis_id"));
                    contact.setMunId(rs.getInt("mun_id"));
                    contact.setDate(rs.getString("time_stamp"));
                    contact.setHazard(rs.getDouble("hazard"));
                    return contact;
                }

                return null;
            }

        });
    }

    @Override
    public List<Earthquake> list(Integer pageId,int total) {
        String sql = "SELECT * FROM "+
                " ( "
                + "select a.*, rownum r__ FROM" +
                "( "
                + "select * from EARTHQUAKES " +
                " ) a " +
                " where rownum < "  +((pageId * total) + 1) +
                ") WHERE r__ >= " + (((pageId - 1)* total)+1);
        List<Earthquake> listEarthquake = jdbcTemplate.query(sql, new RowMapper<Earthquake>() {

            @Override
            public Earthquake mapRow(ResultSet rs, int rowNum) throws SQLException {
                Earthquake aEarthquake = new Earthquake();
                aEarthquake.setId(rs.getInt("quake_id"));
                aEarthquake.setDisId(rs.getInt("dis_id"));
                aEarthquake.setMunId(rs.getInt("mun_id"));
                aEarthquake.setDate(rs.getString("time_stamp"));
                aEarthquake.setHazard(rs.getDouble("hazard"));

                return aEarthquake;
            }

        });

        return listEarthquake;
    }
}
