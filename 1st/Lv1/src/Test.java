import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        int num = 100;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <900; i++) {
            int h = num / 100;
            //h代表百位数字
            int d = (num - h * 100) / 10;
            //d代表十位数字
            int u = num - h * 100 - d * 10;
            //u代表个位数字
            int result = 0;
            result = h * h * h + d * d * d + u * u * u;
            if (result == num) {
                list.add(num);
            }
            num++;
        }
        System.out.print("1000以内的水仙花数：");
        for (int i = 0; i < list.size() ; i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}

