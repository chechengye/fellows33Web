package servlet.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ResponseServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        //设置响应头的状态码
        resp.setStatus(500);
        //设置响应头
        resp.addHeader("name" , "zhangsan");
        resp.addHeader("name" , "lisi");
        resp.addIntHeader("age" , 18);
        resp.setHeader("name" , "lily");
        resp.addDateHeader("birthday" , new Date().getTime());
        //重定向
       /* resp.setStatus(302);
        resp.setHeader("Location" , "/loginServlet");*/
       //resp.sendRedirect("/login.html");
        //向页面写入内容
        resp.getWriter().write("我是测试写入功能！");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
