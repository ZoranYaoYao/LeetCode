package com.zoran.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 1. getMethod getDeclaredMethod 区别?
 * refer:
 * https://www.cnblogs.com/qqzy168/p/3622712.html
 * <p>
 * public Method[] getMethods()返回某个类的所有公用（public）方法包括其继承类的公用方法，当然也包括它所实现接口的方法。
 * public Method[] getDeclaredMethods()对象表示的类或接口声明的所有方法，
 * 包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。当然也包括它所实现接口的方法。
 */
public class ReflectTest {

    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException, NoSuchFieldException, ClassNotFoundException {

        Class cls = Student.class;

        ReflectTest.getClassWay();

        //根据Method 调用静态方法
        Method method = cls.getDeclaredMethod("getAge");
        method.setAccessible(true);
        int age = (int) method.invoke(null);
        System.out.println("age = " + age);
        //根据Filed 调用静态属性
        Field field = cls.getField("age");
        int fileAge = (int) field.get(null);
        System.out.println(fileAge);

        //根据Class类快速创建一个对象
        Student stu = (Student) cls.newInstance();
        System.out.println(stu);

        //通过构造器创建对象
        Constructor constructor = cls.getConstructor(String.class);
        Student stu2 = (Student) constructor.newInstance("zsy");
        System.out.println(stu2.name);

        //getDeclaredMethod 没有问题 getMethod()有问题 ??
        Method method1 = cls.getDeclaredMethod("getName");
        method1.setAccessible(true);
        String name = (String) method1.invoke(stu2);
        System.out.println("反射实例的方法 name = " + name);

        Field filed2 = cls.getDeclaredField("name");
        filed2.setAccessible(true);
        String name2 = (String) filed2.get(stu2);
        System.out.println(name2);




    }

    public static void getClassWay() throws ClassNotFoundException{
        Class class1 = Student.class;

        //内部类需要使用$符号将外部类和内部类进行隔开
        Class class2 = Class.forName("com.zoran.reflect.ReflectTest$Student");

        Class class3 = new Student().getClass();

        System.out.println(class1);
        System.out.println(class2);
        System.out.println(class3);

    }

    static class Student {
        public static int age = 2;

        private String name;

        public Student() {
        }

        public Student(String name) {
            this.name = name;
        }

        private String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        private static int getAge() {
            return age;
        }
    }
}
