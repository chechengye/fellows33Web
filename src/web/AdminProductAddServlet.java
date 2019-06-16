package web;

import domain.Product;
import org.apache.commons.beanutils.BeanUtils;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class AdminProductAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("utf-8");
            ProductService productService = new ProductService();
            Product product = new Product();
            BeanUtils.populate(product , req.getParameterMap());
            System.out.println("product = " + product);
            //1、存储PID
            product.setPid(UUID.randomUUID().toString());
            //2、pflag
            product.setPflag(0);
            //3、存储图片
            product.setPimage("products/1/c_0011.jpg");
            //4、存储日期
            product.setPdate(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date().getTime()));

            productService.addProduct(product);

            resp.sendRedirect(req.getContextPath() + "/adminProductList");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}