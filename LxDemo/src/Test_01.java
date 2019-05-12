import java.util.*;

public class Test_01 {
    public static void main(String[] args) {

        System.out.println("请输入单词数量:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("请依次输入单词:");
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i< num ; i++){
            list.add(sc.next());
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        System.out.println(list.toString());

    }
}
