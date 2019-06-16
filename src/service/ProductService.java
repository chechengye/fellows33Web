package service;

import dao.ProductDao;
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
}
