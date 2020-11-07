import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-05
 * Time: 10:42
 */
class Node {
    char val;
    Node left;
    Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class BinaryTree {
    public Node createTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }
    //前序遍历
    void preOrderTraversal(Node root) {
        if(root == null) return;
        System.out.print(root.val+"  ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //中序遍历
    void inOrderTraversal(Node root) {
        if (root == null) return;
        preOrderTraversal(root.left);
        System.out.print(root.val + "  ");
        preOrderTraversal(root.right);
    }
    //后序遍历
    void postOrderTraversal(Node root) {
        if (root == null) return;
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.println(root.val+ "  ");
    }

    static int size = 0;
    // 遍历思路-求结点个数
    int getSize1(Node root) {
        if (root == null) return 0;
        size++;
        getSize1(root.left);
        getSize1(root.right);
        return size;
    }

    //子问题思路求节点个数
    int getSize2(Node root) {
        if (root == null) return 0;
        return getSize2(root.left) + getSize2(root.right) + 1;
    }
    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    int  getLeafSize1(Node root) {
        if (root == null) return 0;
        if(root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
        return leafSize;
    }
    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root) {
        if (root == null) return 0;
        if(root.left == null && root.right == null) {
            return  1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);


    }
    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root,int k) {
        if (root == null) return 0;
        if(k == 1) {
            return 1;
        }
        return getKLevelSize(root.left,k-1) +
                getKLevelSize(root.right, k-1);

    }
    // 获取二叉树的高度
    int getHeight(Node root){
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    /*Node find(Node root, int val){
        if (root == null) return null;
        if (root.val == val) {
            return root;
        }
    }*/

    //判断两棵树是否相同
    public boolean isSameTree(Node p,Node q) {
        if ((p == null && q != null) || ( p != null && q == null)){
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) &&
                isSameTree(p.right,q.right);
    }
    //判断t是否为s的子树
    public boolean isSubtree(Node s,Node t) {
        if (s == null) {
            return false;
        }
        if (t == null) {
            return true;
        }
        if(isSameTree(s,t)) return true;
        return isSubtree(s.right,t) || isSubtree(s.left,t);
    }
    // 层序遍历
    void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val + "  ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(Node root) {
        return true;
    }

}
