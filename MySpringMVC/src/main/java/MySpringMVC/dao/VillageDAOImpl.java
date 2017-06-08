package MySpringMVC.dao;

import MySpringMVC.model.Village;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static javax.swing.UIManager.get;

public class VillageDAOImpl implements VillageDAO{

    private JdbcTemplate jdbcTemplate;

    public VillageDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void saveOrUpdate(Village village) {
        if (get(village.getId()) != null) {
            // update
            String sql = "UPDATE VILLAGES SET NAME = ?, MUN_ID = ?, DIS_ID = ? WHERE VIL_ID = ? ";
            jdbcTemplate.update(sql, village.getName(), village.getMunId(), village.getDisId(), village.getId());
        } else {
            // insert
            String sql = "INSERT INTO VILLAGES (VIL_ID, MUN_ID, DIS_ID, NAME) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, village.getId(), village.getMunId(), village.getDisId(), village.getName());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM VILLAGES WHERE VIL_ID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Village get(int id) {
        String sql = "SELECT * FROM VILLAGES WHERE VIL_ID = " + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Village>() {

            @Override
            public Village extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Village contact = new Village();
                    contact.setId(rs.getInt("vil_id"));
                    contact.setMunId(rs.getInt("mun_id"));
                    contact.setDisId(rs.getInt("dis_id"));
                    contact.setName(rs.getString("name"));
                    return contact;
                }

                return null;
            }

        });
    }

    @Override
    public List<Village> list() {
        String sql = "SELECT * FROM VILLAGES ORDER BY NAME";
        List<Village> listVillage = jdbcTemplate.query(sql, new RowMapper<Village>() {

            @Override
            public Village mapRow(ResultSet rs, int rowNum) throws SQLException {
                Village aVillage = new Village();

                aVillage.setId(rs.getInt("vil_id"));
                aVillage.setMunId(rs.getInt("mun_id"));
                aVillage.setDisId(rs.getInt("dis_id"));
                aVillage.setName(rs.getString("name"));

                return aVillage;
            }
        });
        return listVillage;
    }
}
