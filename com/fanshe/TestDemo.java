package com.fanshe;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-21
 * Time: 14:15
 */
class Student {
    //私有属性name
    private String name = "bit";
    //公有属性age
    public int age = 18;
    //不带参数的构造方法
    public Student(){
        System.out.println("Student()");
    }
    private Student(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student(String,name)");
    }
    private void eat(){
        System.out.println("i am eat");
    }
    public void sleep(){
        System.out.println("i am pig");
    }
    private void function(String str) {
        System.out.println(str);
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) {
        //验证class对象只有一个
        //获取class对象的三种方式：
        /**
         * 1.getclass
         */
        Student student = new Student();
        Class<?> c1 = student.getClass();
        /**
         * 2.
         */
        Class<?> c2 = Student.class;
        /**
         * 3.
         */
        try {
            Class<?> c3 = Class.forName("com.fanshe.Student");//路径一定要写对
            System.out.println(c1 == c2);
            System.out.println(c2 == c3);
            System.out.println(c1 == c3);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*System.out.println(String.class.getClassLoader());
        System.out.println(Person.class.getClassLoader());*/

    }
}

