import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test_02 {

    // 科特迪瓦，阿根廷，澳大利亚，塞尔维亚，荷兰，
    //尼日利亚、日本，美国，中国，新西 兰，巴西，比利时，韩国，
    //喀麦隆，洪都拉斯，意大利
    public static void main(String[] args) {
        String[] arr = {"科特迪瓦","阿根廷","澳大利亚","塞尔维亚","荷兰","尼日利亚",
                "日本","美国","中国","新西兰","巴西","比利时","韩国","喀麦隆","洪都拉斯","意大利"};
        List<String> list = new ArrayList<>();

        for(String s : arr){
            list.add(s);
        }
        Random r = new Random();
        for(int i = 1; i < 5 ;i++){
            System.out.println("第" + i + "组");
            for(int j = 0 ; j < 4 ; j++){
                int index = r.nextInt(list.size());
                System.out.print(list.get(index) + " ");
                list.remove(index);
            }
            System.out.println();
        }
    }


}
