package com.zoran.leetcode.simple6;

/**
 * �����Ĳ���
 * https://leetcode-cn.com/submissions/detail/13012950/
 *
 * [Solution]
 * https://blog.csdn.net/LawFile/article/details/86671875
 */
public class Test210 {

    public Node construct(int[][] grid) {
        //���ģʽ
        if(grid.length==0) return null;
        return helper(grid,0,0,grid.length);
    }

    Node helper(int[][] grid, int x, int y, int n)
    {
        for(int i=x;i<x+n;i++)
        {
            for(int j=y;j<y+n;j++)
            {
                //Core ��εݹ�4�������ɽڵ㣿��
                if(grid[i][j]!=grid[x][y])
                { //���������������ڵ�ֵ���ڲ�ͬ��˵������Ҷ�ڵ㣬���õݹ�õ��ӽڵ�
                    Node root=new Node(true,false,null,null,null,null);
                    root.topLeft=helper(grid,x,y,n/2);
                    //Core. ��¼X,Y��ֵ�����ѳ���������ԭ����1/2
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
