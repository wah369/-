package com.binaryTree;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-09
 * Time: 23:39
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//合并二叉树

class Solution {
    //递归实现
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode t3 = new TreeNode(t1.val + t2.val);
        t3.left = mergeTrees(t1.left,t2.left);
        t3.right = mergeTrees(t1.right,t2.right);
        return t3;
    }
    //循环实现
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue.offer(merged);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;
    }


}
/////////////////////////////////////////////////////////////////////////////////////////////////
//https://leetcode-cn.com/problems/increasing-order-search-tree/
class Solution3 {
    List<Integer> ret = new LinkedList<>();
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        TreeNode root2 = new TreeNode(0);
        TreeNode root3 = root2;
        for (int i = 0; i < ret.size(); i++) {
            root3.right = new TreeNode(ret.get(i));
            root3 = root3.right;
        }
        return root2.right;
    }
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        ret.add(root.val);
        inorder(root.right);
    }


}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//求最大宽度
class Solution1 {
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        isCompleteTree(root);
        return max;
    }
    //层序遍历，外加一个链表来计算其每一行的下标最大差值
    public void isCompleteTree(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> ret = new LinkedList<>();//队列用来保证数据存放的顺序性
        ret.offer(root);
        LinkedList<Integer> list = new LinkedList<>();//链表用来存储层次遍历过后的二叉树
        list.add(1);
        int index = 1;
        while (!ret.isEmpty()) {
            //为了能够将一层数据弹出，因此设置一个count来存储一层的个数
            int length = ret.size();
            for (int i = 0; i < length; i++) {
                TreeNode cur = ret.poll();
                int x = list.removeFirst();
                if (cur.left != null) {
                    ret.offer(cur.left);
                    list.add(x * 2);
                }
                if (cur.right != null) {
                    ret.offer(cur.right);
                    list.add(x * 2 + 1);
                }
            }
            //如果只有一层，那么最大宽度就是1
            max = index;
            //计算这一层的宽度，就是链表的最后一个元素减去第一个元素
            if (ret.size() >= 2) {
                index = Math.max(index,list.getLast() - list.getFirst() + 1);
                max = index;
            }
        }
    }
}
//题解
class Solution2 {
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        isCompleteTree(root);
        return max;
    }

    public void isCompleteTree(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> q =new LinkedList<>();//队列用来保证数据存放的顺序性
        LinkedList<Integer> list = new LinkedList<>();//链表用来存储层次遍历过后的二叉树
        q.offer(root);//如果根非空，直接入栈
        list.add(1);//并且将根的下标弄为1，并且进入链表中
        int res = 1;
        //开始进入队列，只要队列非空，就弹出队头元素
        while (!q.isEmpty()) {
            //为了能够将一层数据弹出，因此设置一个count来存储一层的个数
            int count = q.size();
            //进入循环
            for(int i =0;i < count;i++){
                TreeNode cur = q.poll();//开始弹出队头元素
                Integer curIndex = list.removeFirst();//因为之前已经直接将根的下标放为1，加入到了链表里面，将它移出来，用来标记它子树的下标
                if(cur.left != null){
                    q.offer(cur.left);
                    list.add(curIndex * 2);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                    list.add(curIndex * 2 +1);
                }
            }
            //从for中出来，一层已经遍历完毕
            //然后计算这一层的宽度，就是链表的最后一个元素减去第一个元素
            max = res;//这张情况宽度为1，因为只有一个根节点
            if(list.size() >= 2) {
                res = Math.max(res, list.getLast() - list.getFirst() + 1);
                max = res;
            }

        }
    }
}


