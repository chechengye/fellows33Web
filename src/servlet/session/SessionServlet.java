package servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取或创建session
        HttpSession session = req.getSession();
        session.setAttribute("name" , "lucy");
        String id = session.getId();
        Cookie cookie = new Cookie("JSESSIONID" , id);
        cookie.setMaxAge(60*10);
        resp.addCookie(cookie);
        //session.invalidate();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req ,resp);
    }
}
