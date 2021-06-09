public class MyArrayList<T> implements MyList<T> {

    //数组默认长度
    private static final int DEFAULT_SIZE = 1;

    //数组
    private Object[] list = null;

    //数组大小
    private int s;

    //当前游标位置
    private int i;

    //判断数组的容量
    private void confirmSize() {
        if (this.i == this.s) {
            this.s = this.i + 1;
            Object[] newList = new Object[this.s];
            for (int j = 0; j < this.list.length; j++) {
                newList[j] = this.list[j];
            }
            this.list = newList;
        }
    }

    //判断下标是否越界
    private void confirmIndex(int index) {
        if (index > s || index < 0) {
            System.out.println("下标越界");
        }
    }

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int size) {
        if (size < 0) {
            System.out.println("数组大小不能小于0");
        } else {
            this.list = new Object[size];
            this.i = 0;
            s = size;
        }

    }

    @Override
    public T get(int index) {
        confirmIndex(index);
        T t = (T) this.list[index];
        return t;
    }

    @Override
    public void add(T t) {
        confirmSize();
        this.list[i] = t;
        this.i++;
    }

    @Override
    public void remove(int index) {
        confirmIndex(index);
        for (int j = index; j < list.length; j++) {
            if (j + 1 < list.length) {
                list[j] = list[j + 1];
            }
        }
        s--;

    }

    @Override
    public void insert(int index, T t) {
        confirmIndex(index);
        Object[] tempList = new Object[s+1];
        for (int j = 0; j < index; j++) {
            tempList[j]=list[j];
        }
            tempList[index]=t;
        for (int j = index+1; j <list.length ; j++) {
            tempList[j]=list[j];
        }
        list=tempList;
        s++;
    }

    @Override
    public int size() {
        return this.s;
    }

    @Override
    public void contains(Object o) {
        confirmSize();
        boolean result = false;
        for (int j = 0; j < s; j++) {
            if (o.equals(list[j])) {
                result = true;
                break;
            }
        }
        if (result==true){
            System.out.println(o+"在数组中");
        }else {
            System.out.println(o+"不在数组中");
        }
    }
    public static void printList(MyArrayList list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
