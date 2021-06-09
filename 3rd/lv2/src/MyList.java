public interface MyList<T> {
    //获取数据
    T get(int index);
    //新增数据
    void add(T t);
    //移除数据
    void remove(int index);
    //插入数据
    void insert(int index,T t);
    //数组长度
    int size();
    //是否存在元素
    void contains(Object o);

}
