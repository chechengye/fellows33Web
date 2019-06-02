package servlet.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public class RequestServlet1 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
       //获取请求行里面的请求方式
        String method = req.getMethod();
        System.out.println("method = " + method);

        //获取请求行内的路径
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL = " + requestURL);

        //获取项目路径
        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        String contextPath = req.getContextPath();

        System.out.println("contextPath = " + contextPath);

        //resp.sendRedirect(req.getContextPath() + "/loginServlet");

        //获取get方式请求参数 ,不建议使用了解
       /* String queryString = req.getQueryString();
        resp.getWriter().write(queryString);*/

       //获取远程客户端的ip地址
       /* String remoteAddr = req.getRemoteAddr();
        resp.getWriter().write("您的IP地址为:" + remoteAddr);*/

        String header = req.getHeader("User-Agent");
        //resp.getWriter().write(header);

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            System.out.println(headerNames.nextElement());
        }

        String referer = req.getHeader("referer");
      /*  if(null != referer && referer.startsWith("http://localhost")){
            resp.getWriter().write("刘翔获得3块金牌....");
        }else{
            resp.getWriter().write("你是盗链者，可耻！！！");
        }*/
        //获取参数值
        String[] hobbies = req.getParameterValues("hobby");

        for(String h : hobbies){
            System.out.println(h);
        }
        System.out.println("--------------------");
        //获取所有参数名称
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()){
            System.out.println(names.nextElement());
        }
        System.out.println("--------------------");
        //自动封装map
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for(Map.Entry<String, String[]> e : entries){
            for(String s : e.getValue()){
                System.out.println(e.getKey() + ":" + s);
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
