package com.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-21
 * Time: 14:59
 */
public class ReflectClassDemo {
    //通过反射获取对象
    public static void reflectNewInstance() {
        try {
            Class<?> classStudent = Class.forName("com.fanshe.Student");
            Object objectStudent = classStudent.newInstance();
            Student student = (Student) objectStudent;
            System.out.println("获得学生对象："+student);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // 反射私有的构造方法 屏蔽内容为获得公有的构造方法
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classStudent = Class.forName("com.fanshe.Student");
            //注意传入对应的参数
            Constructor<?> declaredConstructorStudent =
                    classStudent.getDeclaredConstructor(String.class,int.class);
            //Constructor<?> declaredConstructorStudent = classStudent.getConstructor();
            //调用setAccessible 设置为true后可修改访问权限
            declaredConstructorStudent.setAccessible(true);

            Object objectStudent = declaredConstructorStudent.newInstance("高博",15);
            //Object objectStudent = declaredConstructorStudent.newInstance();
            Student student = (Student) objectStudent;
            System.out.println("获得私有构造哈数且修改姓名和年龄："+student);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // 反射私有属性
    public static void reflectPrivateField() {
        try {
            Class<?> classStudent = Class.forName("com.fanshe.Student");
            Field field = classStudent.getDeclaredField("name");
            field.setAccessible(true);
            //可以修改该属性的值
            Object objectStudent = classStudent.newInstance();
            Student student = (Student) objectStudent;

            //field.set(修改的属性的对象的引用，修改的值)
            field.set(student, "小明");

            //通过反射调用属性：field.get(这个对象的某个属性)
            String name = (String) field.get(student);
            System.out.println("反射私有属性修改了name：" + name);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // 反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class<?> classStudent = Class.forName("com.fanshe.Student");
            Method methodStudent = classStudent.getDeclaredMethod("function",String.class);
            System.out.println("私有方法的方法名为："+methodStudent.getName());
            //私有的一般都要加
            methodStudent.setAccessible(true);
            Object objectStudent = classStudent.newInstance();
            Student student = (Student) objectStudent;
            //通过反射调用方法
            methodStudent.invoke(student,"我是给私有的function函数传的参数");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reflectNewInstance();
        reflectPrivateConstructor();
        reflectPrivateField();
        reflectPrivateMethod();
    }

}
