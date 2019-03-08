package com.zoran.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class WeakReferenceCar extends WeakReference<Car> {
    public WeakReferenceCar(Car car) {
        super(car);
    }
}

