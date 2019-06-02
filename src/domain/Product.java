package domain;

import java.io.Serializable;

public class Product implements Serializable{

    /**
     *  `pid` varchar(32) NOT NULL,
     `pname` varchar(50) DEFAULT NULL,
     `market_price` double DEFAULT NULL,
     `shop_price` double DEFAULT NULL,
     `pimage` varchar(200) DEFAULT NULL,
     `pdate` date DEFAULT NULL,
     `is_hot` int(11) DEFAULT NULL,
     `pdesc` varchar(255) DEFAULT NULL,
     `pflag` int(11) DEFAULT NULL,
     `cid` varchar(32) DEFAULT NULL,
     */
    private String pid;
    private String pname;
    private String market_price;
    private String shop_price;
    private String pimage;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getMarket_price() {
        return market_price;
    }

    public void setMarket_price(String market_price) {
        this.market_price = market_price;
    }

    public String getShop_price() {
        return shop_price;
    }

    public void setShop_price(String shop_price) {
        this.shop_price = shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", market_price='" + market_price + '\'' +
                ", shop_price='" + shop_price + '\'' +
                ", pimage='" + pimage + '\'' +
                '}';
    }
}
