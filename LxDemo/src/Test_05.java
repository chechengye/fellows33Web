/**
 * 5. 抽象类、自定义异常、继承相关练习
 1)、建立一个Java抽象类Drink
 a、声明一个抽象方法taste() 该方法负责输出饮料的味道
 b、声明静态工厂方法getDrink(int drinkType)根据传入的参数创建不同的饮料对象
 并返回该对象 建议使用switch语句。该方法要求声明DrinkNotFoundException 当没有相对应的饮料类型时 抛出该异常。
 2)、建立Drink的具体子类
 a、分别建立Drink的子类 Coffee 代表咖啡 Beer 代表啤酒 Milk 代表牛奶 ;
 b、实现taste()方法 要求在控制台打印各自的味道特征。
 3)、建立异常类DrinkNotFoundException
 a、继承Exception
 b、在Drink的 方 法getDrink(int drinkType)中 声 明 引 发DrinkNotFoundException异常 当传入的参数没有相对应的饮料类型时 抛出异常。
 c、在使用getDrink方法的类中捕捉该异常。

 4)、建立Test测试类 测试以上内容的正确性
 a、编写main方法 通过命令行传参的方式传入某种饮料的类型。
 b、在main方法中 调用Drink类的getDrink方法 获得相应的饮料对象。注意捕获DrinkNotFoundException。
 c、然后调用该饮料对象的taste()方法 输出该饮料的味道。


 */

public class Test_05 {
    public static void main(String[] args) {
        try{
            Drink drink = Drink.getDrink(5);
            drink.taste();
        }catch (Exception e){
            System.out.println(new DrinkNotFoundException("您传入的值有问题!范围1~3"));
        }
    }
}

abstract class Drink{
    abstract void taste();
    public static Drink getDrink(int drinkType) throws DrinkNotFoundException{

        if(drinkType < 1 || drinkType > 3){
            throw new DrinkNotFoundException();
        }
        switch (drinkType){
            case 1:
                return new Coffee();
            case 2:
                return new Bear();
            case 3:
                return new Milk();
        }
        return null;
    }
}
class Coffee extends Drink{

    @Override
    void taste() {
        System.out.println("我是咖啡,我是苦涩的！");
    }
}
class Bear extends Drink{

    @Override
    void taste() {
        System.out.println("我是啤酒，我是醉人的!");
    }
}

class Milk extends Drink{

    @Override
    void taste() {
        System.out.println("我是牛奶，我是甜的!");
    }
}
class DrinkNotFoundException extends Exception{
    public DrinkNotFoundException(){
        super();
    }

    public DrinkNotFoundException(String msg){
        super(msg);
    }
}