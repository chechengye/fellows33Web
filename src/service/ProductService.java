package service;

import dao.ProductDao;
import domain.Category;
import domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    private ProductDao productDao;
    public ProductService(){
        productDao = new ProductDao();
    }
    public Product getProductByPid(String pid) throws SQLException {
        return productDao.getProductByPid(pid);
    }

    public List<Product> getAllProduct() throws SQLException {
        return productDao.getAllProduct();
    }

    public List<Category> getAllCategory() throws SQLException {
        return productDao.getAllCategory();
    }

    public void addProduct(Product product) throws SQLException {
        productDao.addProduct(product);
    }

    public void deleteProductByPid(String pid) throws SQLException {
        productDao.deleteProductByPid(pid);
    }
}
