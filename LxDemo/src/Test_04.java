import java.util.*;

/**
 * 4.（Map）设计Account 对象 ， 包含(id,  balance， password)属性。 通过集合创建3个以上
 * Account 对象id自动分配。
 要求把List 中的内容放到一个Map 中，该Map 的键为id，值为相应的Account 对象。
 最后遍历这个Map，打印所有Account 对象的id 和余额。。

 */
public class Test_04 {
    public static void main(String[] args) {
        List<Account> list = new ArrayList<>();
        list.add(new Account(3.22 , "1234"));
        list.add(new Account(55 , "33"));
        list.add(new Account(33 , "1234334"));

        Map<Integer , Account> map = new HashMap<>();
        for (Account a : list){
            map.put(a.getId() , a);
        }

        Set<Map.Entry<Integer, Account>> entries = map.entrySet();
        entries.forEach(a -> System.out.println("id: " + a.getKey() +
                "余额:" + a.getValue().getBalance()));
    }
}
class Account{

    private int id;
    private double balance;
    private String password;

    public Account(double balance, String password) {
        this.id = (int)(Math.random() * 1000) + 1000;
        this.balance = balance;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }
}