package jdbc;

import jdbc.utils.JDBCUtils;
import jdk.nashorn.internal.scripts.JD;
import org.junit.Test;

import java.sql.*;

public class TestJDBC {

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
