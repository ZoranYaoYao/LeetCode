package com.zoran.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");list.add("b");list.add("c");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("o1 = " + o1);
                System.out.println("02 = " + o2);
                return -o1.compareTo(o2); //
            }
        });
        System.out.println(list);

    }
}
