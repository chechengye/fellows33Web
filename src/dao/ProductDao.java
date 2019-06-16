package dao;

import domain.Category;
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

    public List<Category> getAllCategory() throws SQLException {
        String sql = "select * from category";
        List<Category> categoryList = qr.query(sql, new BeanListHandler<>(Category.class));
        return categoryList;
    }

    public void addProduct(Product product) throws SQLException {
        String sql = "insert into product values (?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql , product.getPid() , product.getPname()
                , product.getMarket_price() ,product.getShop_price() , product.getPimage()
                ,product.getPdate() ,product.getIs_hot() ,product.getPdesc() ,product.getPflag() ,product.getCid() );
    }

    public void deleteProductByPid(String pid) throws SQLException {
        String sql = "delete from product where pid = ?";
        qr.update(sql , pid);
    }
}
