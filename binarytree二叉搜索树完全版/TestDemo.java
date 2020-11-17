package binarytree;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-17
 * Time: 9:04
 */
class BinarySearchTree {
    static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    Node root = null;
    //存放
    public void put(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }
        Node parent = null;
        Node cur = root;

        while (cur != null) {
            if (cur.data < key) {
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
        //此时cur=null，parent = cur的父亲
        if (parent.data < key) {
            parent.right = node;
        }else {
            parent.left = node;
        }
    }
    //中序
    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    //前序
    public void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    //查找
    public  Node findKey(int key) {
        if (root == null) return null;
        Node cur = root;
        while (cur != null) {
            if (cur.data < key) {
                cur = cur.right;
            }else if(cur.data > key) {
                cur = cur.left;
            }else {
                return cur;
            }
        }
        return null;
    }
    ///////////////////删除///////////////////////////////////////////////
    public  boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.data == key) {
                removeNode(parent,cur);
                return true;
            }else if(cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
        return false;
    }

    /**
     *
     * @param parent 要删除的父节点
     * @param cur  要删除的节点
     */
    public void removeNode(Node parent,Node cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            }else if(parent.left == cur) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            }else if (parent.left == cur) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            //替换法：1左树找最大值，2右树找最小值
            //选2，右树找最小值
            Node targetParent = cur;
            Node target = targetParent.right;
            while (target.left != null) {
                targetParent = target;
                target = targetParent.left;
            }
            cur.data = target.data;
            if (targetParent.left == target) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        int[] array = {15, 23, 19, 67, 4, 19, 10};
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.put(array[i]);
        }
        binarySearchTree.inorder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.preorder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.put(15);
        binarySearchTree.inorder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.preorder(binarySearchTree.root);
        System.out.println("========================");
        System.out.println(binarySearchTree.findKey(15).data);
        System.out.println("=======================");
        binarySearchTree.remove(15);
        binarySearchTree.inorder(binarySearchTree.root);
    }
}

