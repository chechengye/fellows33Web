package servlet;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pool.C3P0Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        login(username , password ,req , resp);
    }

    public void login(String username , String password ,HttpServletRequest req,HttpServletResponse resp){


        try {
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "select * from t_user where uname = ? and upassword = ?";
            User user = qr.query(sql, new BeanHandler<>(User.class), username , password);
            resp.setContentType("text/html;charset=utf-8");
            System.out.println("user = " +user);
            if(user != null){
                //重定向
                resp.sendRedirect(req.getContextPath() + "/index.html");
            }else{
                //resp.getWriter().write("登陆失败！");
                //请求转发
                req.setCharacterEncoding("utf-8");
                req.setAttribute("info" , "用户名或密码错误!");
                req.getRequestDispatcher(req.getContextPath() + "/login.jsp").forward(req , resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
