package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ShowSomething")
public class HelloWorld extends HttpServlet {

    private static final String HOST = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "student";
    private static final String PASS = "STUDENT";
    private static String query;
    private static Statement statement;

    public HelloWorld() throws SQLException {
        Connection connection = DriverManager.getConnection(HOST, USER, PASS);
        statement = connection.createStatement();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("button1");
        String result = "";

        try {
            result = getQuestion(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        out.println("<font color=red>No user found with given email id, please register first.</font>" + result);
        out.close();
        //throw new ServletException("DB Connection problem."); ///you get it

        response.sendRedirect("index.html"); ///redirect to a page
    }

    public static String getMessage() {
        return "Cartofi prajiti";
    }

    public static String get(String wot) {
        String result = "87";

        result += " " + wot;

        return result;
    }

    public static String getQuestion(String idQuestion) throws SQLException {
        String message = "";

        query += "select * from questions where id = " + idQuestion;

        try {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                for (int i = 1; i <= 11; i++) {
                    message += rs.getString(i) + "\t";
                }
                message += "\n";
            }

        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return message;
    }


}
