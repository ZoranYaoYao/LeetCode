package com.zoran.generic;

public class GenericTest {

    public static void main(String[] args) {
        //�ֲ�����
        People<String> people = new People<>();
        people.getClass().getTypeName();
    }

}

class People<T> {
    T value;


}
