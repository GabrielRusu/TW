package MySpringMVC.dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;


import javax.sql.DataSource;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.Scheduled;

import MySpringMVC.model.District;
import MySpringMVC.model.Municipality;
import MySpringMVC.model.Population;
import javafx.scene.control.Cell;
import javafx.util.Pair;


public class TablesDAOImpl {

    private JdbcTemplate jdbcTemplate;

    public TablesDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createChart2() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ION", "ION");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet query_set = stmt.executeQuery("SELECT * FROM (SELECT d.gov_damaged,d.public_damaged, di.name AS name FROM damages d " +
                    "JOIN districts di ON (di.dis_id = d.dis_id) " +
                    "ORDER BY (d.gov_damaged + d.public_damaged) DESC) WHERE rownum < 10");
            while (query_set.next()) {
                int gov_damaged = query_set.getInt("gov_damaged");
                int public_damaged = query_set.getInt("public_damaged");
                String dis_id = query_set.getString("name");
                int damages = gov_damaged + public_damaged;
                dataset.addValue(damages, dis_id, dis_id);
            }
            JFreeChart BarChartObject = ChartFactory.createBarChart("Top 10 districts with the most damages",
                    "Districts", "Damages", dataset, PlotOrientation.VERTICAL,
                    true, true, false);
            query_set.close();
            stmt.close();
            conn.close();


            File f = new File(TablesDAOImpl.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String path;

            for (int i = 0; i < 4; i++) {
                f = f.getParentFile();
            }
            path = f.getAbsolutePath() + "\\src\\main\\webapp\\resources\\images\\";

            try {
                path = URLDecoder.decode(path, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            int width = 1280;
            int height = 720;

            File BarChart = new File(path + "output_chart.png");
            try {
                ChartUtilities.saveChartAsPNG(BarChart, BarChartObject, width, height);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception i) {
            System.out.println(i);
        }
    }

    public void createChart() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "ION",
                    "ION");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM (SELECT d.name AS namee, sum(da.male_death)+sum(da.fem_death)+sum(da.fem_injured)+sum(da.male_injured) AS yes" +
                " FROM damages da JOIN districts d ON (d.dis_id = da.dis_id) GROUP BY d.name ORDER BY yes DESC) WHERE rownum < 11 ";
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DefaultPieDataset dataset = new DefaultPieDataset();

        try {
            while (resultSet.next()) {
                dataset.setValue(
                        resultSet.getString("dis_id"),
                        Double.parseDouble(resultSet.getString("yes")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createPieChart("", dataset, false, true, false);

        File f = new File(TablesDAOImpl.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String path;

        for (int i = 0; i < 4; i++) {
            f = f.getParentFile();
        }
        path = f.getAbsolutePath() + "\\src\\main\\webapp\\resources\\images\\";

        try {
            path = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int width = 1280;
        int height = 720;
        File pieChart = new File(path + "Pie_Chart.jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void retrieveFile(String urlString, String file) throws IOException {
        URL url = new URL(urlString);
        byte[] buffer = new byte[1024];
        int count = 0;

        BufferedInputStream stream = new BufferedInputStream(url.openStream());
        FileOutputStream output = new FileOutputStream(file);

        while ((count = stream.read(buffer, 0, 1024)) != -1) {
            output.write(buffer, 0, count);
        }

        output.close();
        stream.close();
    }

    public void importPopulation(String file) {
        String line = "";
        String separator = ",";
        BufferedReader br = null;

        System.out.println(" >> Updating table Population :: ");

        String sql = "DELETE FROM POPULATION WHERE DIS_ID != 0";
        jdbcTemplate.update(sql);

        try {
            br = new BufferedReader(new FileReader(file));
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] columns = line.split(separator);

                sql = "INSERT INTO POPULATION(DIS_ID, MUN_ID, HOUSEHOLDS, MALE_POP, FEM_POP, DENSITY) " +
                        "VALUES(" + columns[0] + ", " + columns[2] + ", " + columns[9] +
                        ", " + columns[11] + ", " + columns[12] + ", " + columns[13] + ") ";

                jdbcTemplate.update(sql);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(" >> Table Population updated :: ");

    }


    public void updatePopulation() {
        String url = "https://data.humdata.org/dataset/e71f53d9-2339-4df5-b76e-397957ec65dc/resource/1f6474a1-a0c3-4646-8f16-b57a4f5411cf/download/npl-popt-adm4-2011-wfp.csv";
        File f = new File(TablesDAOImpl.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String path;

        for (int i = 0; i < 4; i++) {
            f = f.getParentFile();
        }
        path = f.getAbsolutePath() + "\\src\\temp";

        try {
            path = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            retrieveFile(url, path + "\\population.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        importPopulation(path + "\\population.csv");
    }

    @Scheduled(cron = "0 0 0 * * *")
    void checkUpdate() throws IOException {

        String url = "https://data.humdata.org/dataset/e71f53d9-2339-4df5-b76e-397957ec65dc/resource/1f6474a1-a0c3-4646-8f16-b57a4f5411cf/download/npl-popt-adm4-2011-wfp.csv";
        File f = new File(TablesDAOImpl.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String path;

        for (int i = 0; i < 4; i++) {
            f = f.getParentFile();
        }
        path = f.getAbsolutePath() + "\\src\\temp";
        path = URLDecoder.decode(path, "UTF-8");

        retrieveFile(url, path + "\\population-new.csv");

        System.out.println(" >> Checking if update is available :: ");

        String file1 = path + "\\population.csv";
        String file2 = path + "\\population-new.csv";

        BufferedReader bfr1 = new BufferedReader(new FileReader(file1));
        BufferedReader bfr2 = new BufferedReader(new FileReader(file2));

        String one, two;

        while (((one = bfr1.readLine()) != null) && ((two = bfr2.readLine()) != null)) {
            if (one.compareTo(two) != 0) {
                File fileOne = new File(file1);
                File fileTwo = new File(file2);

                fileOne.delete();
                fileTwo.renameTo(fileOne);

                System.out.println(" >> Update found for Table Population :: ");

                importPopulation(file1);
                return;
            }
        }

    }
}

