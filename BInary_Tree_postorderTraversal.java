import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BInary_Tree_postorderTraversal {
    // 1. recurisve
    List<Integer> postorderTraversal_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    void helper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        helper( node.left, res);
        helper( node.right, res);
        res.add(node.val);
    } 
    // 2. iterative left

    List<Integer> postoderTraversal_iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (root.right == null || (res.size() != 0 && res.get(res.size() - 1).equals(root.right.val))) {
                res.add(root.val);
                root = null;
            }
            else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    // 3. 前序的逆序列
    List<Integer> postoderTraversal_iterative_2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.addFirst(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        return res;
    }

}