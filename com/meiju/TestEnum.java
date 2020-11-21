package meiju;

import java.lang.reflect.Constructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-21
 * Time: 18:51
 */

//自己写的枚举类会默认继承于Enum
public enum TestEnum {
    RED("红色",1),BLACK("黑色",1),GREEN("绿色",3),WHITE("白色",4);  //都属于枚举对象

    public String color;
    public int ordinal;

    TestEnum(String color,int ordinal) {
        this.color = color;
        this.ordinal = ordinal;
    }
    public static TestEnum getEnumKey (int key) {
        for (TestEnum t: TestEnum.values()) {
            if(t.ordinal == key) {
                return t;
            }
        }
        return null;
    }

    public static void reflectPrivateConstructor() {
        try {
            Class<?> classStudent = Class.forName("meiju.TestEnum");
            //注意传入对应的参数,获得对应的构造方法来构造对象,当前枚举类是提供了两个参数分别是String和int。
            Constructor<?> declaredConstructorStudent =
                    classStudent.getDeclaredConstructor(String.class,int.class);
            //设置为true后可修改访问权限
            declaredConstructorStudent.setAccessible(true);
            Object objectStudent = declaredConstructorStudent.newInstance("绿色",666);
            TestEnum testEnum = (TestEnum) objectStudent;
            System.out.println("获得枚举对象："+testEnum);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reflectPrivateConstructor();
    }

/////////////////////////////////////////////////////////////////////////
    public static void main2(String[] args) {
        TestEnum[] testEnums = TestEnum.values();
        for (int i = 0; i < testEnums.length; i++) {
            //打印内容
            //System.out.print(testEnums[i]+" ");
            //打印下标
            //System.out.print(testEnums[i].ordinal()+" ");
        }
        System.out.println(TestEnum.valueOf("BLACK"));

        TestEnum testEnum1 = BLACK;
        TestEnum testEnum2 = TestEnum.GREEN;
        System.out.println(testEnum1.compareTo(testEnum2));
        System.out.println(RED.compareTo(WHITE));

    }

    public static void main1(String[] args) {
        TestEnum testEnum2 = TestEnum.BLACK;
        switch (testEnum2) {
            case RED:
                System.out.println("red");
                break;
            case BLACK:
                System.out.println("black111");
                break;
            case WHITE:
                System.out.println("WHITE");
                break;
            case GREEN:
                System.out.println("black");
                break;
            default:
                break;
        }
    }
}

