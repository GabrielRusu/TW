package MySpringMVC.dao;


import MySpringMVC.model.Damage;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DamageDAOImpl implements DamageDAO{

    private JdbcTemplate jdbcTemplate;

    public DamageDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void saveOrUpdate(Damage Damage) {
        if (get(Damage.getDisId()) != null) {
            // update
            String sql = "UPDATE DAMAGES SET MALE_DEATH = ? , FEM_DEATH = ?,MALE_INJURED = ?, FEM_INJURED = ?, PUBLIC_DAMAGED = ? WHERE DIS_ID = ?";
            jdbcTemplate.update(sql, Damage.getMaleDeath(),Damage.getFemDeath(),Damage.getMaleInjured(),Damage.getFemInjured(),Damage.getPublicDamages(), Damage.getDisId());
        } else {
            // insert
            String sql = "INSERT INTO DAMAGES (dis_id,MALE_DEATH,FEM_DEATH,MALE_INJURED,FEM_INJURED,PUBLIC_DAMAGED) VALUES (?, ?, ?,?,?)";
            jdbcTemplate.update(sql,Damage.getDisId(),Damage.getMaleDeath(),Damage.getFemDeath(),Damage.getMaleInjured(),Damage.getFemInjured(),Damage.getPublicDamages());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM DAMAGES WHERE dis_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Damage get(int id) {
        String sql = "SELECT * FROM DAMAGES WHERE DIS_ID = " + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Damage>() {

            @Override
            public Damage extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Damage contact = new Damage();
                    contact.setDisId(rs.getInt("dis_id"));
                    contact.setMaleDeath(rs.getInt("male_death"));
                    contact.setFemDeath(rs.getInt("fem_death"));
                    contact.setMaleInjured(rs.getInt("male_injured"));
                    contact.setFemInjured(rs.getInt("fem_injured"));
                    contact.setPublicDamages(rs.getInt("public_damaged"));
                    return contact;
                }

                return null;
            }

        });
    }

    @Override
    public List<Damage> list() {
        String sql = "SELECT * FROM DAMAGES";
        List<Damage> listDamage = jdbcTemplate.query(sql, new RowMapper<Damage>() {

            @Override
            public Damage mapRow(ResultSet rs, int rowNum) throws SQLException {
                Damage aDamage = new Damage();

                aDamage.setDisId(rs.getInt("dis_id"));
                aDamage.setMaleDeath(rs.getInt("male_death"));
                aDamage.setFemDeath(rs.getInt("fem_death"));
                aDamage.setMaleInjured(rs.getInt("male_injured"));
                aDamage.setFemInjured(rs.getInt("fem_injured"));
                aDamage.setPublicDamages(rs.getInt("public_damaged"));

                return aDamage;
            }

        });

        return listDamage;
    }
    
}
