package com.zoran.reference;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 弱引用
 *
 * refer:
 * https://www.cnblogs.com/szlbm/p/5504645.html
 *
 * 关联的对象会被回收，但是自己是强引用，是不会被回收的！！
 */
public class WeakReference_Test {

    public static void main(String[] args)
    {
        Car car = new Car(2000.0, "red");
        /**
         * 弱引用也是改变，car的实例对象回收
         * 而自己确实强引用！！
         */
        WeakReference<Car> wrc = new WeakReference<>(car);
        int i = 0;
        while (true)
        {
            if (wrc.get() != null)
            {
                i++;
                System.out.println("WeakReferenceCar's Car is alive for " + i + ", loop - " + wrc);
            }
            else
            {
                System.out.println("WeakReferenceCar's Car has bean collected, " + wrc);
//                break;
            }
        }
    }

    public static void inheritWeakReference(){
        Car car = new Car(2000.0, "red");
        /**
         * 弱引用，指向的是父类包含的car，回收的也是car对象
         *
         */
        WeakReferenceCar wrc = new WeakReferenceCar(car);
        int i = 0;
        while (true)
        {
            if (wrc.get() != null)
            {
                i++;
                System.out.println("WeakReferenceCar's Car is alive for " + i + ", loop - " + wrc);
            }
            else
            {
                System.out.println("WeakReferenceCar's Car has bean collected, " + wrc);
                break;
            }
        }
    }
}
