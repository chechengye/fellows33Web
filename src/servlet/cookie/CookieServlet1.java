package servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet1 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建cookie
        Cookie cookie = new Cookie("age" , "20");
        //持久化cookie
        cookie.setMaxAge(60*10);
        //设置cookie响应域
        cookie.setPath(req.getContextPath() + "/cookieServlet1");
        //添加cookie
        resp.addCookie(cookie);
        //删除cookie

        //获取cookie
        Cookie[] cookies = req.getCookies();
        for(Cookie c : cookies){
            if(c.getName().equals("age")){
                resp.getWriter().write(c.getValue());
            }
        }



        /*Cookie cookie1 = new Cookie("age" , "20");
        //持久化cookie
        cookie1.setMaxAge(0);
        //设置cookie响应域
        cookie1.setPath(req.getContextPath() + "/cookieServlet1");
        //添加cookie
        resp.addCookie(cookie1);*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
