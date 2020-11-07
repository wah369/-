

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
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println(binaryTree.getSize1(root));
        System.out.println(binaryTree.getSize2(root));
        System.out.println(binaryTree.getLeafSize2(root));
        System.out.println(binaryTree.getLeafSize1(root));
        System.out.println(binaryTree.getKLevelSize(root,3));
        binaryTree.levelOrderTraversal(root);
    }
}
