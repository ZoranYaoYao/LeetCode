package com.zoran.reference;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * ������
 *
 * refer:
 * https://www.cnblogs.com/szlbm/p/5504645.html
 *
 * �����Ķ���ᱻ���գ������Լ���ǿ���ã��ǲ��ᱻ���յģ���
 */
public class WeakReference_Test {

    public static void main(String[] args)
    {
        Car car = new Car(2000.0, "red");
        /**
         * ������Ҳ�Ǹı䣬car��ʵ���������
         * ���Լ�ȷʵǿ���ã���
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
         * �����ã�ָ����Ǹ��������car�����յ�Ҳ��car����
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
