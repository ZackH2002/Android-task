import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){
        String encoding = "UTF-8";
        List list = new ArrayList<String>();
        try{
            FileReader reader = new FileReader("F:\\Android_task\\4th\\src\\taxi_gps.txt");
            BufferedReader reader1 = new BufferedReader(reader);
            String line;
            while ((line= reader1.readLine())!=null){
                String result =line.substring(0,5);
                boolean a = isContain(list,result);
                if (a==false){
                    list.add(result);
                }
            }
        }catch (IOException e){
            System.out.println("异常"+ e.toString());
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("该出租车中共包含"+list.size()+"辆车");

    }

    public static boolean isContain(List<String> arr, String targetValue) {
        for(String s: arr){
            if(s.equals(targetValue))
                return true;
        }
        return false;
    }
}
