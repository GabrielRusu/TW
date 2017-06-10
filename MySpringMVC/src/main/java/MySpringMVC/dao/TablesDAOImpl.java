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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


import javax.sql.DataSource;

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
    void checkUpdate() throws IOException, UnsupportedEncodingException, FileNotFoundException {

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
