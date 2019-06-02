package servlet.request;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class RegisterServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决从前端获取的乱码问题
        req.setCharacterEncoding("UTF-8");
        /*
        user.setUname(req.getParameter("username"));
        user.setUpassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        register(user);
        System.out.println("user = " + user);*/

        /*Object name = req.getAttribute("name");
        System.out.println(name);*/

        try {
            String hobby = "";
            User user = new User();
            Map<String, String[]> parameterMap = req.getParameterMap();
            BeanUtils.populate(user , parameterMap);
            Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
            for(Map.Entry<String, String[]> e : entries){
                if(e.getKey().equals("hobby")){
                    for(String h : e.getValue()){
                        hobby += "," + h;
                    }
                }
            }
            System.out.println("hobby");
            //user.setId(UUID.randomUUID());
            user.setHobby(hobby);
            register(user , req , resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public void register(User user , HttpServletRequest req , HttpServletResponse resp){

        try {
            //创建QueyRunner对象
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            System.out.println("qr = " + qr);
            //添加用户
            String sql = "insert into t_user values (null , ?, ? ,?, ?, ? ,?)";
            int rows = qr.update(sql, user.getUname(), user.getUpassword(), user.getEmail(), user.getHobby(), user.getSex(), user.getCode());
            if(rows > 0){
                //重定向
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
