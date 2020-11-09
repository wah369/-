import java.util.*;

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

    public Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
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
        if (root == null) return;
        System.out.print(root.val + "  ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + "  ");
        inOrderTraversal(root.right);
    }

    //后序遍历
    void postOrderTraversal(Node root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val + "  ");
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

    int getLeafSize1(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
        return leafSize;
    }

    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);


    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root, int k) {
        if (root == null) return 0;
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left, k - 1) +
                getKLevelSize(root.right, k - 1);

    }

    // 获取二叉树的高度
    int getHeight(Node root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ?
                leftHeight + 1 : rightHeight + 1;
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        }
        Node ret1 = find(root.left, val);
        if (ret1 != null) {
            return ret1;
        }
        Node ret2 = find(root.right, val);
        if (ret2 != null) {
            return ret2;
        }
        return null;
    }

    //判断两棵树是否相同
    public boolean isSameTree(Node p, Node q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    //判断t是否为s的子树
    public boolean isSubtree(Node s, Node t) {
        if (s == null || t == null) {
            return false;
        }
        if (isSameTree(s.left, t)) return true;
        if (isSameTree(s.right, t)) return true;
        return false;
    }

    //判断一棵树是否为高度平衡二叉树
    public boolean isBalanced(Node root) {
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        /*if(leftHeight > rightHeight && leftHeight - rightHeight >= 2) {
            return false;
        }else if(leftHeight < rightHeight && rightHeight - leftHeight >= 2) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right); */
        //绝对值函数求代码更简洁
        return Math.abs(leftHeight - rightHeight) < 2
                && isBalanced(root.left) && isBalanced(root.right);
    }

    //给定一个二叉树，检查它是否是镜像对称的
    public boolean isSymmetric(Node root) {
        if (root == null) return true;
        return isSymmetricChild(root.left, root.right);
    }

    public boolean isSymmetricChild(Node leftTree, Node rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree != null && rightTree == null ||
                leftTree == null && rightTree != null) return false;
        if (leftTree.val != rightTree.val) return false;
        return isSymmetricChild(leftTree.left, rightTree.right) &&
                isSymmetricChild(leftTree.right, rightTree.left);
    }

    // 层序遍历
    //运用栈的原理弹出一个元素打印，同时添加其左和右，
    void levelOrderTraversal(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    //oj题层序遍历,返回数组类型的
    public List<List<Character>> levelOrder(Node root) {
        List<List<Character>> ret = new ArrayList<>();
        if (root == null) return ret;
        //queue保证顺序
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            //rowList层序过程中是每一行的数据
            List<Character> rowList = new ArrayList<>();
            while (count != 0) {
                Node cur = queue.poll();
                rowList.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                count--;
            }
            ret.add(rowList);
        }
        return ret;
    }

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(Node root) {
        if (root == null) return true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node ret = queue.poll();
            if (ret != null) {
                queue.offer(ret.left);
                queue.offer(ret.right);
            } else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            Node ret = queue.peek();
            if (ret != null) {
                return false;
            } else {
                queue.poll();
            }
        }
        return true;
    }
}
// 牛客网：https://www.nowcoder.com/questionTerminal/4b91205483694f449f94c179883c1fef
// 编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
// 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
// 建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果
// 输入abc##de#g##f### 。输入c b e g d f a
class Node2 {
    char val;
    Node2 left;
    Node2 right;

    public Node2(char val) {
        this.val = val;
    }

    public Node2(char val, Node2 left, Node2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //先把字符串以前序遍历构建二叉树
    public static int i = 0;

    public static Node2 creatTreeByString(String str) {
        Node2 root = null;
        if (str.charAt(i) != '#') {
            root = new Node2(str.charAt(i));
            i++;
            root.left = creatTreeByString(str);
            root.right = creatTreeByString(str);
        } else {
            i++;
        }
        return root;
    }

    //然后中序遍历
    public static void inOrderTraversal(Node2 root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + "  ");
        inOrderTraversal(root.right);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        Node2 root = creatTreeByString(str);
        inOrderTraversal(root);
    }
}
    // 二叉树的最近公共祖先
class Solution1 {
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
       if(root == null) {
           return null;
       }
       if(root == p || root == q) {
           return root;
       }
       Node leftTree = lowestCommonAncestor(root.left,p,q);
       Node rightTree = lowestCommonAncestor(root.right,p,q);
       if(leftTree != null && rightTree != null) {
           return root;
       }
       if(leftTree != null) {
           return leftTree;
       }
       if(rightTree != null) {
           return rightTree;
       }
       return null;
    }
}
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向

class Solution2 {
    public Node prev = null;
    public void ConvertChild(Node root) {
        if (root == null) return;
        ConvertChild(root.left);
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        ConvertChild(root.right);
    }

    public Node Convert(Node pRootOfTree) {
        if (pRootOfTree == null) return null;
        ConvertChild(pRootOfTree);
        Node head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }
}

//你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
// 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
class Solution3 {
    public void tree2strChild(Node t, StringBuilder sb) {
        if (t == null) return;
        sb.append(t.val);
        if (t.left == null) {
            if (t.right == null) {
                return;
            } else {
                sb.append("()");
            }
        } else {
            sb.append("(");
            tree2strChild(t.left, sb);
            sb.append(")");
        }

        if (t.right == null) {
            return;
        } else {
            sb.append("(");
            tree2strChild(t.right, sb);
            sb.append(")");
        }
    }

    public String tree2str(Node t) {
        if (t == null) return null;
        StringBuilder sb = new StringBuilder();
        tree2strChild(t, sb);
        return sb.toString();
    }

    public int preIndex = 0;

    public Node buildTreeChild(char[] preorder,
                               char[] inorder, int inbegin, int inend) {
        if (inbegin > inend) {
            return null;
        }
        Node root = new Node(preorder[preIndex]);
        int inorderIndex = findInoderIndexOfRoot(inorder,
                inbegin, inend, preorder[preIndex]);
        preIndex++;
        root.left = buildTreeChild(preorder,
                inorder, inbegin, inorderIndex - 1);
        root.right = buildTreeChild(preorder,
                inorder, inorderIndex + 1, inend);
        return root;
    }

    public int findInoderIndexOfRoot(char[] inorder,
                                     int inbegin, int inend, char val) {
        for (int j = inbegin; j <= inend; j++) {
            if (inorder[j] == val) {
                return j;
            }
        }
        return -1;
    }


    public Node buildTree(char[] preorder, char[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeChild(preorder, inorder,
                0, inorder.length - 1);
    }
}

