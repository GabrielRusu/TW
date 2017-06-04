package example;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Hello World";

        ArrayList<District> list = new ArrayList<>();
        District district = new District();
        District district2 = new District();

        for (int i = 0; i <= 3; i++) {
            district.setId(i);
            district.setName("District " + i);
            list.add(district);
        }
        district2.setId(23);
        district2.setName("YOUW TOWN AMETE");
        list.add(district2);

        request.setAttribute("message", list); // This will be available as ${message}
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

}