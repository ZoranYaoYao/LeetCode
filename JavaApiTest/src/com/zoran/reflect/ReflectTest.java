package com.zoran.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 1. getMethod getDeclaredMethod ����?
 * refer:
 * https://www.cnblogs.com/qqzy168/p/3622712.html
 * <p>
 * public Method[] getMethods()����ĳ��������й��ã�public������������̳���Ĺ��÷�������ȻҲ��������ʵ�ֽӿڵķ�����
 * public Method[] getDeclaredMethods()�����ʾ�����ӿ����������з�����
 * ����������������Ĭ�ϣ��������ʺ�˽�з��������������̳еķ�������ȻҲ��������ʵ�ֽӿڵķ�����
 */
public class ReflectTest {

    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException, NoSuchFieldException, ClassNotFoundException {

        Class cls = Student.class;

        ReflectTest.getClassWay();

        //����Method ���þ�̬����
        Method method = cls.getDeclaredMethod("getAge");
        method.setAccessible(true);
        int age = (int) method.invoke(null);
        System.out.println("age = " + age);
        //����Filed ���þ�̬����
        Field field = cls.getField("age");
        int fileAge = (int) field.get(null);
        System.out.println(fileAge);

        //����Class����ٴ���һ������
        Student stu = (Student) cls.newInstance();
        System.out.println(stu);

        //ͨ����������������
        Constructor constructor = cls.getConstructor(String.class);
        Student stu2 = (Student) constructor.newInstance("zsy");
        System.out.println(stu2.name);

        //getDeclaredMethod û������ getMethod()������ ??
        Method method1 = cls.getDeclaredMethod("getName");
        method1.setAccessible(true);
        String name = (String) method1.invoke(stu2);
        System.out.println("����ʵ���ķ��� name = " + name);

        Field filed2 = cls.getDeclaredField("name");
        filed2.setAccessible(true);
        String name2 = (String) filed2.get(stu2);
        System.out.println(name2);




    }

    public static void getClassWay() throws ClassNotFoundException{
        Class class1 = Student.class;

        //�ڲ�����Ҫʹ��$���Ž��ⲿ����ڲ�����и���
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
