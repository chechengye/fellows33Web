package servlet;

import javax.servlet.*;
import java.io.IOException;

public class QuickStartServlet implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init running ...");
        System.out.println(servletConfig.getServletName());
        System.out.println(servletConfig.getInitParameter("driver"));
        //ServletContext context = servletConfig.getServletContext();

    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service running ...");

    }

    @Override
    public void destroy() {
        System.out.println("destroy running ...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public String getServletInfo() {
        return null;
    }


}
