import java.util.ArrayList;
import java.util.List;

/**
 * 3.有如下Student 对象 ， 包含(name ,  age ， score ， className) 属性。
 通过集合创建5个以上学生对象。计算学生得平均年龄和每个班级的平均分
 (创建两个以上班级一样的学生)。
 */
public class Test_03 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三" , 18 , 67 , "一班"));
        list.add(new Student("李四" , 22 , 55 , "一班"));
        list.add(new Student("王五" , 19 , 88 , "二班"));
        list.add(new Student("赵六" , 21 , 74 , "二班"));
        list.add(new Student("中山" , 25 , 25 , "三班"));
        int totalAge = 0;
        int clsNum1 = 0;
        int clsNum2 = 0;
        int clsNum3 = 0;
        double totalScore1 = 0.0d;
        double totalScore2 = 0.0d;
        double totalScore3 = 0.0d;
        for (Student s : list) {
            totalAge+=s.getAge();
            if(s.getClassName().equals("一班")){
                totalScore1+= s.getScore();
                clsNum1++;
            }

            if(s.getClassName().equals("二班")){
                totalScore2+= s.getScore();
                clsNum2++;
            }

            if(s.getClassName().equals("三班")){
                totalScore3+= s.getScore();
                clsNum3++;
            }
        }
        System.out.println("学生的平均年龄:" + (totalAge == 0 ? 0 : totalAge / list.size()));
        System.out.println("一班:" + totalScore1 / clsNum1 + ",二班:" + totalScore2 / clsNum2 + ",三班:" + totalScore3 / clsNum3);
    }
}
class Student{
    private String name;
    private int age;
    private double score;
    private String className;

    public Student(String name, int age, double score, String className) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", className='" + className + '\'' +
                '}';
    }
}