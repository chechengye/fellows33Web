package web;

import domain.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProductInfoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String pid = req.getParameter("pid");
            ProductService productService = new ProductService();
            //1、通过pid获取product
            Product product = productService.getProductByPid(pid);
            //2、将product存到域里面
            req.setAttribute("product" ,product);
            //3、内部转发jsp页面
            req.getRequestDispatcher("product_info.jsp").forward(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req ,resp);
    }
}
