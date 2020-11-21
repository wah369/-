package com.lambaddemo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-21
 * Time: 19:50
 */
//函数式接口

//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    //注意：只能有一个方法
    void test();
}
//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}
//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}
//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}
//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}

public class TestDemo {
    public static void main(String[] args) {
        //有返回值无参数
        NoParameterReturn np = ()->{return 10;};
        NoParameterReturn np2 = ()->10;
        System.out.println(np.test());
        System.out.println(np2.test());
        //有返回值1个参数
        OneParameterReturn op = (int a)->{return a;};
        OneParameterReturn op2 = a -> a;
        System.out.println(op.test(20));
        System.out.println(op2.test(30));

        //有返回值多个参数
        MoreParameterReturn mr = (int a,int b)->{
            return a+b;
        };
        System.out.println(mr.test(1, 2));

        MoreParameterReturn mr2 = (a,b)-> a+b;
        System.out.println(mr2.test(3, 4));


    }

    //无返回值
    public static void main1(String[] args) {
        //无返回值无参数
        NoParameterNoReturn np = () ->{
            System.out.println("hello");
        };
        np.test();

        //无返回值一个参数
        /*OneParameterNoReturn op = (a)->{
            System.out.println(a);
        };*/
        OneParameterNoReturn op = a-> System.out.println(a);
        op.test(10);

        //无返回值多个参数
        MoreParameterNoReturn mp = (int a,int b)->{
            System.out.println(a+b);
        };
        mp.test(10,20);

    }

}
