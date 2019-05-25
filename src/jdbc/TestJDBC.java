package jdbc;

import jdbc.utils.JDBCUtils;
import jdk.nashorn.internal.scripts.JD;
import org.junit.Test;
import pool.C3P0Utils;
import pool.MyConnectionPool;

import java.sql.*;

public class TestJDBC {

    @Test
    public void testLogin(){
        login("lisi" , "123");
    }

    @Test
    public void updateUser(){
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "update t_user set uname = '测试C3P0' where id = 2";
            conn = C3P0Utils.getConnection();
            pstmt = conn.prepareStatement(sql);
            int rows = pstmt.executeUpdate();
            if(rows > 0){
                System.out.println("修改成功！");
            }else{
                System.out.println("修改失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testInsertUser(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        MyConnectionPool connectionPool =null;
        try {
            String sql = "insert into t_user values(null , '吴亦凡' , '1583' , 'wuyf_wc@163.com')";
            connectionPool = new MyConnectionPool();
            conn = connectionPool.getConnection();
            pstmt = conn.prepareStatement(sql);
            int rows = pstmt.executeUpdate();
            if(rows > 0){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.returnConn(conn);
        }

    }
    
    public void login(String username , String password){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //1、加载驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fellows33", "root", "root");
            //3、获取stateMent对象
            conn = JDBCUtils.getConnection();
            //st = conn.createStatement();
            //4、编写sql语句
            //String sql = "select * from t_user where uname = '"+username+"' and upassword = '"+password+"'";
            String sql = "select * from t_user where uname = ? and upassword = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1 , username);
            pstmt.setString(2 , password);

            //5、执行sql语句
            rs= pstmt.executeQuery();
            if(rs.next()){
                System.out.println(sql);
                System.out.println("欢迎," + username);
            }else {
                System.out.println("用户名或密码错误！");
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.releaseRes(conn , pstmt , rs);
        }
    }

    @Test
    public void testQuery(){
        Connection conn = null;
        Statement st = null;
        ResultSet rt = null;
        try {
            //1、加载驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fellows33", "root", "root");
            //3、获取stateMent对象
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            //4、编写sql语句
            String sql = "select * from t_user";
            //5、执行sql语句
            rt = st.executeQuery(sql);

            while (rt.next()){
                System.out.println("用户名：" + rt.getString("uname") + "邮箱: " + rt.getString(4) );
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.releaseRes(conn , st , rt);
        }
    }
}
