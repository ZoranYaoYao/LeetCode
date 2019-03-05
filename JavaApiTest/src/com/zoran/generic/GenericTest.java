package com.zoran.generic;

public class GenericTest {

    public static void main(String[] args) {
        //局部变量
        People<String> people = new People<>();
        people.getClass().getTypeName();
    }

}

class People<T> {
    T value;


}
