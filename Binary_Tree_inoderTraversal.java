import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Binary_Tree_inoderTraversal {
    // 1. recursive
    List<Integer> inoderTraversal_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;    
    }
    void helper(TreeNode node, List<Integer> res) {
        helper(node.left, res);
        res.add(node.val);
        helper(node.right, res);
    }

    // 2.iterative left children are stored to the stack
    List<Integer> inorderTraversal_iterative_left(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
    }

    // 3.iterative right children are stored to stack
     
    List<Integer> inorderTraversal_iterative_right(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.
            }
        }
    }

}