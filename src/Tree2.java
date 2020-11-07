import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-05
 * Time: 11:12
 */


     class TreeNode {
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
  class Tree2 {
      public List<Integer> preorderTraversal(TreeNode root) {
          List<Integer> list = new ArrayList<>();
          if (root == null) return list;
          list.add(root.val);
          List<Integer> leftList = preorderTraversal(root.left);
          list.addAll(leftList);
          List<Integer> rightList = preorderTraversal(root.right);
          list.addAll(rightList);
          return list;
      }
  }

