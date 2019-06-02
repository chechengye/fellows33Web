package servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LastAccessServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd+hh:mm:ss");
        String s = format.format(date);
        Cookie cookie = new Cookie("lastTime" , s);
        cookie.setMaxAge(60*600*10);
        String lastTime = null;
        resp.addCookie(cookie);

        Cookie[] cookies = req.getCookies();
        if(null != cookies){
            for(Cookie c : cookies){
                if(c.getName().equals("lastTime")){
                    lastTime = c.getValue();
                    lastTime = lastTime.replace("+" , " ");
                }
            }
        }


        if(null == lastTime){
            resp.getWriter().write("您是第一次访问！");
        }else {
            resp.getWriter().write("您上次的访问时间为:" + lastTime);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
