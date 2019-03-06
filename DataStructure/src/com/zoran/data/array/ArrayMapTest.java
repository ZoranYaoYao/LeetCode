package com.zoran.data.array;

/**
 * ArrayMap
 *
 * refer:
 * https://www.jianshu.com/p/1fb660978b14
 *
 * 底层数据结构:
 * int[] mHashes;
 * Object[] mArray;
 *
 * 添加元素时：
 *         mHashes[index] = hash;
 *         mArray[index<<1] = key;
 *         mArray[(index<<1)+1] = value;
 */
public class ArrayMapTest {
}
