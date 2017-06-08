package MySpringMVC.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import MySpringMVC.model.Population;

public class PopulationDAOImpl implements PopulationDAO {

    private JdbcTemplate jdbcTemplate;

    public PopulationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Population population) {
        if (get(population.getMunId()) != null) {
            // update
            String sql = "UPDATE POPULATION SET DIS_ID = ?, HOUSEHOLDS = ?, MALE_POP = ?, FEM_POP = ? ," +
                    "DENSITY = ? WHERE MUN_ID = ? ";
            jdbcTemplate.update(sql, population.getMunId(), population.getHouseholds(), population.getMalePop(),
                    population.getFempop(), population.getDensity(), population.getDisId());
        } else {
            // insert
            String sql = "INSERT INTO POPULATION(DIS_ID, MUN_ID, HOUSEHOLDS, MALE_POP, FEM_POP, " +
                    "DENSITY) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, population.getDisId(), population.getMunId(), population.getHouseholds(),
                    population.getMalePop(), population.getFempop(), population.getDensity());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM POPULATION WHERE MUN_ID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Population get(int id) {
        String sql = "SELECT * FROM POPULATION WHERE MUN_ID = " + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Population>() {

            @Override
            public Population extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Population population = new Population();
                    population.setMunId(rs.getInt("mun_id"));
                    population.setDisId(rs.getInt("dis_id"));
                    population.setHouseholds(rs.getInt("households"));
                    population.setMalePop(rs.getInt("male_pop"));
                    population.setFempop(rs.getInt("fem_pop"));
                    population.setDensity(rs.getFloat("density"));
                    return population;
                }

                return null;
            }

        });
    }

    @Override
    public List<Population> list() {
        String sql = "SELECT * FROM POPULATION ";
        List<Population> listPopulation = jdbcTemplate.query(sql, new RowMapper<Population>() {

            @Override
            public Population mapRow(ResultSet rs, int rowNum) throws SQLException {
                Population population = new Population();
                population.setMunId(rs.getInt("mun_id"));
                population.setDisId(rs.getInt("dis_id"));
                population.setHouseholds(rs.getInt("households"));
                population.setMalePop(rs.getInt("male_pop"));
                population.setFempop(rs.getInt("fem_pop"));
                population.setDensity(rs.getFloat("density"));
                return population;
            }

        });

        return listPopulation;
    }
}
