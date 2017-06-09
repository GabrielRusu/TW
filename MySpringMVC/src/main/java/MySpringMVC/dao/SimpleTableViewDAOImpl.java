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
import MySpringMVC.model.PopStatistics;
import MySpringMVC.model.ProjectActivity;

public class SimpleTableViewDAOImpl {

    private JdbcTemplate jdbcTemplate;

    public SimpleTableViewDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PopStatistics> list() {
        String sql = "SELECT d.NAME AS name, SUM(p.MALE_POP + p.FEM_POP) AS population, " +
                "(da.MALE_DEATH + da.FEM_DEATH) AS dead, (da.MALE_INJURED + da.FEM_INJURED) AS injured " +
                "FROM DAMAGES da JOIN DISTRICTS d ON da.DIS_ID = d.DIS_ID " +
                "JOIN POPULATION p ON (d.DIS_ID = p.DIS_ID) " +
                "GROUP BY d.NAME, da.MALE_DEATH, da.FEM_DEATH, da.MALE_INJURED, da.FEM_INJURED " +
                "ORDER BY d.NAME ";

        List<PopStatistics> listPopStatistics = jdbcTemplate.query(sql, new RowMapper<PopStatistics>() {

            @Override
            public PopStatistics mapRow(ResultSet rs, int rowNum) throws SQLException {
                PopStatistics aStatistic = new PopStatistics();
                aStatistic.setName(rs.getString("name"));
                aStatistic.setPopulation(rs.getInt("population"));
                aStatistic.setDead(rs.getInt("dead"));
                aStatistic.setInjured(rs.getInt("injured"));
                return aStatistic;
            }

        });

        return listPopStatistics;
    }

    public List<ProjectActivity> list2() {
        String sql = "SELECT c.NAME AS cName, d.NAME AS dName, m.NAME AS mName, " +
                "  ACTIVITY_TYPE AS activity, ITEM, TOTAL, UNIT " +
                "  FROM PROJECTS p JOIN CLUSTERS c ON (p.CLUS_ID = c.CLUS_ID) " +
                "  JOIN DISTRICTS d ON (d.DIS_ID = p.DIS_ID) " +
                "  JOIN MUNICIPALITIES m ON (m.MUN_ID = p.MUN_ID)";

        List<ProjectActivity> listPopStatistics = jdbcTemplate.query(sql, new RowMapper<ProjectActivity>() {

            @Override
            public ProjectActivity mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProjectActivity projectActivity = new ProjectActivity();
                projectActivity.setCluster(rs.getString("cName"));
                projectActivity.setDistrict(rs.getString("dName"));
                projectActivity.setMunicipality(rs.getString("mName"));
                projectActivity.setActivity(rs.getString("activity"));
                projectActivity.setItem(rs.getString("item"));
                projectActivity.setTotal(rs.getInt("total"));
                projectActivity.setUnit(rs.getString("unit"));
                return projectActivity;
            }

        });

        return listPopStatistics;
    }
    

}
