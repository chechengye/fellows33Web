package servlet.jsptest;

import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProductServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //获取数据库中的商品列表
            //1、创建一个QueryRunner对象
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            //2、编写sql语句
            String sql = "select * from product";
            //3、执行查询操作
            List<Product> productList = qr.query(sql, new BeanListHandler<>(Product.class));
            System.out.println("productList = " + productList);
            //4、内部转发jsp页面
            req.setAttribute("productList" , productList);
            req.getRequestDispatcher(req.getContextPath() + "/product_list.jsp").forward(req , resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
