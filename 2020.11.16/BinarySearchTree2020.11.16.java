package binarytree;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-16
 * Time: 11:39
 */

public class BinarySearchTree {
    static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    static Node root = null;
    public static void put(int key) {
        Node node = new Node(key);
        if(root == null) {
            root = node;
            return;
        }
        Node parent = null;
        Node cur = root;
        while (cur != null) {
            if(cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else if(cur.data > key) {
                parent = cur;
                cur = cur.left;
            }else {
                cur.data = key;
                return;
            }
        }
        //cur == null parent = cur的父亲
        if(parent.data < key) {
            parent.right = node;
        }else {
            parent.left = node;
        }
    }


    public static Node findVal(int val) {
        if(root == null) return null;
        Node cur = root;
        while (cur != null) {
            if(cur.data == val) {
                return cur;
            }else if(cur.data < val){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }

    public static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        int[] array = {15,23,19,67,4,19,10};

        for (int i = 0; i < array.length; i++) {
             put(array[i]);
        }
        put(15);
        inorder(root);
        System.out.println("=====================");
        preorder(root);
        System.out.println("===================");
        try {
            System.out.println(findVal(167).data);
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("没有这个节点");
        }
    }
}
