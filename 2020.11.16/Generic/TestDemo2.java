package Generic;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-16
 * Time: 21:51
 */
class GenericAlg <T extends Comparable> {
    //<T extends Comparable> 泛型的上界 ， T实现了Comparable的接口
    //或者说Comparable实现了Comparable本身
    public  T maxValue(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}
//静态方法：
class GenericAlg2  {
    //<T extends Comparable> 泛型的上界 ， T实现了Comparable的接口
    //或者说Comparable实现了Comparable本身
    public static<T extends Comparable<T>> T maxValue(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}
class MyPrint<T> {
    public void printf(ArrayList<T> list) {
        for (T val : list) {
            System.out.print(val+" ");
        }
    }
}

/**
 * 通配符：源码当中
 * 泛型的区别：
 * 1，通配符一般用于读取
 * 2，通配符不仅有上界 <? extends 上界> 还有下界 <? super 下界>
 */
class MyPrint2<T> {
    public void printf(ArrayList<?> list) {
        for (Object val : list) {
            System.out.print(val+" ");
        }
    }
}

public class TestDemo2 {

    public static void main(String[] args) {
        MyPrint<Integer> myPrint = new MyPrint<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        myPrint.printf(arrayList);
    }
    public static void main2(String[] args) {
        Integer[] array = {1,3,5,7,9};
        System.out.println(GenericAlg2.maxValue(array));
        System.out.println(GenericAlg2.<Integer>maxValue(array));
        //不写Integer会根据实参类型判断
    }

    public static void main1(String[] args) {
        Integer[] array = {5,2,4,9,7,6,3,8};
        GenericAlg<Integer> gla = new GenericAlg<>();
        System.out.println(gla.maxValue(array));

        GenericAlg2.maxValue(array);

    }
}
