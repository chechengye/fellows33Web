package servlet.jsptest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletTestJsp extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8\n");
        resp.getWriter().write("<!DOCTYPE html>\n");
        resp.getWriter().write(" <html lang=\"en\">");
        resp.getWriter().write("<head>");
        resp.getWriter().write("<meta charset=\"UTF-8\">");
        resp.getWriter().write("<title>测试</title>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<h1>测试静态页面</h1>");
        resp.getWriter().write("  </body>");
        resp.getWriter().write(" </html>");

        /**
         * <!DOCTYPE html>
         <html lang="en">
         <head>
         <meta charset="UTF-8">
         <title>测试</title>
         </head>
         <body>
         <h1>测试静态页面</h1>
         </body>
         </html>
         */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
