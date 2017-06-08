package MySpringMVC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import MySpringMVC.model.MapInfo;


public class MapViewDAOImpl {


    private JdbcTemplate jdbcTemplate;

    public MapViewDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<MapInfo> list(int hazard) {
        String sql = "SELECT m.mun_id AS id, m.name AS name, e.time_stamp AS time, " +
                "e.hazard AS hazard, round(avg(substr(v.coords, instr(v.coords, '(')+1, 17)),15) as coord1, " +
                "round(avg(substr(v.coords, instr(v.coords, '(')+19, 17)),15) as coord2 " +
                "FROM villages v JOIN earthquakes e ON (v.dis_id = e.dis_id AND v.mun_id = e.mun_id) " +
                "JOIN municipalities m ON (v.dis_id = m.dis_id AND v.mun_id = m.mun_id) ";

        switch (hazard) {
            case 0:
                sql += "WHERE hazard < 0.05 ";
                break;
            case 1:
                sql += "WHERE hazard < 0.1 AND hazard >= 0.05 ";
                break;
            case 2:
                sql += "WHERE hazard < 0.5 AND hazard >= 0.1 ";
                break;
            case 3:
                sql += "WHERE hazard < 1 AND hazard >= 0.5 ";
                break;
            case 4:
                sql += "WHERE hazard < 1.5 AND hazard >= 1 ";
                break;
            case 5:
                sql += "WHERE hazard >= 1.5 ";
                break;
            default:
                sql += "WHERE hazard < 0 ";
        }
        sql += "GROUP BY m.mun_id, m.name, e.time_stamp, e.hazard ";

        List<MapInfo> listMapInfo = jdbcTemplate.query(sql, new RowMapper<MapInfo>() {

            @Override
            public MapInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                MapInfo aMapInfo = new MapInfo();

                aMapInfo.setId(rs.getInt("id"));
                aMapInfo.setName(rs.getString("name"));
                aMapInfo.setTimeStamp(rs.getString("time"));
                aMapInfo.setHazard(rs.getDouble("hazard"));
                aMapInfo.setCoord1(rs.getString("coord1"));
                aMapInfo.setCoord2(rs.getString("coord2"));

                return aMapInfo;
            }

        });

        return listMapInfo;
    }
}
