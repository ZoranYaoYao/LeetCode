package com.zoran.leetcode.simple6;

/**
 * 建立四叉树
 * https://leetcode-cn.com/submissions/detail/13012950/
 *
 * [Solution]
 * https://blog.csdn.net/LawFile/article/details/86671875
 */
public class Test210 {

    public Node construct(int[][] grid) {
        //组合模式
        if(grid.length==0) return null;
        return helper(grid,0,0,grid.length);
    }

    Node helper(int[][] grid, int x, int y, int n)
    {
        for(int i=x;i<x+n;i++)
        {
            for(int j=y;j<y+n;j++)
            {
                //Core 如何递归4叉树生成节点？？
                if(grid[i][j]!=grid[x][y])
                { //发现正方形区域内的值存在不同，说明不是叶节点，调用递归得到子节点
                    Node root=new Node(true,false,null,null,null,null);
                    root.topLeft=helper(grid,x,y,n/2);
                    //Core. 记录X,Y的值，并把长度缩减到原来的1/2
                    root.topRight=helper(grid,x,y+n/2,n/2);
                    root.bottomLeft=helper(grid,x+n/2,y,n/2);
                    root.bottomRight=helper(grid,x+n/2,y+n/2,n/2);
                    return root;
                }
            }
        }
        boolean val= (grid[x][y] == 1);
        return new Node(val,true,null,null,null,null);
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}
