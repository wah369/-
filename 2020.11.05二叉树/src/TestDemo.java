

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-05
 * Time: 14:49
 */
public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.createTree();
        binaryTree.preOrderTraversal(root);  //前序遍历
        System.out.println();
        binaryTree.inOrderTraversal(root);   //中序遍历
        System.out.println();
        binaryTree.postOrderTraversal(root);  //后序遍历
        System.out.println();
        //获取二叉树的节点个数
        System.out.println(binaryTree.getSize1(root));
        System.out.println(binaryTree.getSize2(root));
        //获取叶子节点个数
        System.out.println(binaryTree.getLeafSize2(root));
        System.out.println(binaryTree.getLeafSize1(root));
        System.out.println("================================");
        //第k层节点个数
        System.out.println(binaryTree.getKLevelSize(root,3));
        //求二叉树的深度
        System.out.println(binaryTree.getHeight(root));
        System.out.println("================================");
        //层序遍历
        binaryTree.levelOrderTraversal(root);
    }
}
