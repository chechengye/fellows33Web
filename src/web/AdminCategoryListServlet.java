package web;

import domain.Category;
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
import java.util.List;

public class AdminCategoryListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ProductService productService = new ProductService();
            List<Category> categoryList =  productService.getAllCategory();
            req.setAttribute("categoryList" , categoryList);
            req.getRequestDispatcher("admin/product/add.jsp").forward(req , resp);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}