import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> noteList1 = new ArrayList<Integer>();
        ArrayList<Integer> noteList2 = new ArrayList<Integer>();
        ArrayList<Integer> noteList3 = new ArrayList<Integer>();
        System.out.println("请输入第一个note的内容并以0结束");
        initNote(noteList1);
        System.out.println("请输入第二个note的内容并以0结束");
        initNote(noteList2);
        System.out.print("note1:");
        printNote(noteList1);
        System.out.print("note2:");
        printNote(noteList2);
        combineNote(noteList1,noteList2,noteList3);
        System.out.print("排序前note3:");
        printNote(noteList3);
        sort(noteList3);
        System.out.print("排序后note3:");
        printNote(noteList3);
        }
    public static void initNote(List list){
        Scanner scanner1 = new Scanner(System.in);
        int i=1;
        while (true) {
            System.out.print("请输入第" + i + "个数据：");
            i=i+1;
            int note1 = scanner1.nextInt();
            if (note1 != 0) {
                list.add(note1);
            } else {
                break;
            }

        }
    }
    public static void printNote(List list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
    public static void combineNote(List list1,List list2,List list3){
        //将两个数组合并
        for (int i = 0; i < list1.size(); i++) {
            list3.add(list1.get(i));
        }
        for (int j = 0; j < list2.size(); j++) {
            list3.add(list2.get(j));
        }
    }
    public static void sort(List<Integer> list){
        
        for (int i = 0; i <  list.size();i++) {
            for (int j = 0; j < list.size()-1 ; j++) {
                if (list.get(j+1)<= list.get(j)){
                    int min=0;
                    min= list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1,min);
                }
            }
            }
        }
    }
