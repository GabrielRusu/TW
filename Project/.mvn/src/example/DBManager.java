package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

    private static final String HOST = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "ION";
    private static final String PASS = "ION";
    private static String query;
    private static Statement statement;

    public DBManager() throws SQLException {
        Connection connection = DriverManager.getConnection(HOST, USER, PASS);
        statement = connection.createStatement();
    }

    public static Statement getStatement() {
        return statement;
    }

    public static String getQuery() {
        return query;
    }

    public static void setQuery(String query) {
        DBManager.query = query;
    }

}