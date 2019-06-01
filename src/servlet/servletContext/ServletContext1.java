package servlet.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContext1 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        String parameter = context.getInitParameter("url");
        String realPath_a = context.getRealPath("WEB-INF/a.txt");

        String realPath_b = context.getRealPath("WEB-INF/classes/b.txt");
        System.out.println("parameter = " + parameter +
                ",realPath_a = " + realPath_a + ",realPath_b = " + realPath_b);
        context.setAttribute("xx" , "lucy");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
