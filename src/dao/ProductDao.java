package dao;

import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {

    private QueryRunner qr;
    public ProductDao(){
        qr = new QueryRunner(C3P0Utils.getDataSource());
    }
    public Product getProductByPid(String pid) throws SQLException {
        String sql = "select * from product where pid = ?";
        Product product = qr.query(sql, new BeanHandler<>(Product.class), pid);
        return product;
    }

    public List<Product> getAllProduct() throws SQLException {
        String sql = "select * from product";
        List<Product> productList = qr.query(sql, new BeanListHandler<>(Product.class));
        return productList;
    }
}
