package com.zoran.data.tree;

/**
 *
 * https://blog.csdn.net/u013411246/article/details/81088914
 *
 * 二叉搜索树： 指子节点<=2, 左子树小于父节点， 右子树大于父节点。
 * B树(B-tree)： Banlance-Tree 指 多路搜索树，每个结点存储M/2到M个关键字，非叶子结点存储指向关键字范围的子结点；
 * B+树：在B-树基础上，为叶子结点增加链表指针，所有关键字都在叶子结点中出现，非叶子结点作为叶子结点的索引；B+树总是到叶子结点才命中
 * B*树：在B+树基础上，为非叶子结点也增加链表指针，将结点的最低利用率；
 */
public class B_Tree {
}
