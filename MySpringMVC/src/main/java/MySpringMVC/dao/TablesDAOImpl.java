package MySpringMVC.dao;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


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


    public void update() {
        String url = "https://data.humdata.org/dataset/9feb2044-2e3f-40de-9317-afb1f55b2e63/resource/b383fecf-a068-4b32-8694-eb8919296b24/download/";
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

        System.out.println(path);

        try {
            retrieveFile(url, path + "\\bla.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
