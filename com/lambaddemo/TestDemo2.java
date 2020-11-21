package com.lambaddemo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-21
 * Time: 22:00
 */
class Test {

}
@FunctionalInterface
interface NoParameterNoReturn2 {
    void test();
}
public class TestDemo2 {
    //map中的forEach
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        map.put(2,"world");
        map.put(3,"hello");
        map.put(4,"lambda");
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println("key: "+integer+" value: "+s);
            }
        });
        //Lambda表达式
        map.forEach((key,value)-> System.out.println("key: "+key+" value: "+value));
    }

    public static void main4(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("abc");
        list.add("world");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //Lambda表达式
        list.sort((o1,o2)->{return o1.compareTo(o2);});
        list.sort((o1, o2) -> o1.compareTo(o2));

        list.forEach((s)-> System.out.println(s));
    }
    //List接口forEach
    public static void main3(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //Lambda表达式
        list.forEach((s)-> System.out.println(s));
    }


    public static void main2(String[] args) {
        int a = 99;
        //a = 88;
        NoParameterNoReturn2 np = ()->{
            //a = 88;
            System.out.println(a);
        };
        np.test();
    }
    /**
     * 匿名内部类当中捕获的常量一定是常量或者是没有改变过的量
     * @param args
     */
    public static void main1(String[] args) {
        int a = 10;
        //匿名内部类
        new Test() {
          public void func() {
              System.out.println(a);
          }
        }.func();
    }
}
