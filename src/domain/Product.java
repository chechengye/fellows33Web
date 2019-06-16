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
    private String pdesc;
    private int is_hot;
    private int pflag;
    private String cid;
    private String pdate;




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

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public int getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public int getPflag() {
        return pflag;
    }

    public void setPflag(int pflag) {
        this.pflag = pflag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", market_price='" + market_price + '\'' +
                ", shop_price='" + shop_price + '\'' +
                ", pimage='" + pimage + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", is_hot=" + is_hot +
                ", pflag=" + pflag +
                ", cid='" + cid + '\'' +
                '}';
    }
}
