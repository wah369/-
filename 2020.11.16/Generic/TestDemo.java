package Generic;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-16
 * Time: 19:22
 */



class MyArrayList<T> {

    public T[] elem;
    public int usedSize;

    public MyArrayList() {
        this.elem =(T[]) new Object[10];
    }
    public void push(T val) {
        this.elem[this.usedSize++] = val;
    }
    public T get() {
        return this.elem[0];
    }
}
public class TestDemo {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.push(1);
        myArrayList.push(2);
        int val = myArrayList.get();
        System.out.println(val);
        MyArrayList<String> myArrayList2 = new MyArrayList<>();
        System.out.println(myArrayList);
        System.out.println(myArrayList2);
    }

}
