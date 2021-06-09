public class test {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        System.out.println("list数组为:");
        MyArrayList.printList(list);
        list.remove(1);
        System.out.println();
        System.out.println("删除第二个元素后的数组：");
        MyArrayList.printList(list);
        System.out.println();
        System.out.println("在第三个元素插入3");
        list.insert(2, 3);
        MyArrayList.printList(list);
        System.out.println();
        list.contains(4);
        System.out.println();
        list.contains(5);
        MyArrayList<Character> list1 = new MyArrayList<Character>();
        list1.add('a');
        list1.add('b');
        list1.add('c');
        MyArrayList.printList(list1);
        System.out.println();
        System.out.println("删除第二个元素后的数组");
        list1.remove(1);
        MyArrayList.printList(list1);
        list1.insert(1,'d');
        System.out.println();
        System.out.println("插入第二元素后");
        MyArrayList.printList(list1);
        System.out.println();
        list1.contains('a');
        list1.contains('f');
    }

}
