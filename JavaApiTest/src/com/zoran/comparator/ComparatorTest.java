package com.zoran.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator
 */
public class ComparatorTest {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");list.add("b");list.add("c");
        Collections.sort(list, new Comparator<String>() {
            /**??? 从源码上看，
             * o1代表后面的一个数
             * o2代表o1前面的一个数
             *
             * 如果return >0 则升序
             * 如果return <0 则降序！
             *
             * 最后的结果的都是自然排序，就是说一定是升序！！
             * */
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
