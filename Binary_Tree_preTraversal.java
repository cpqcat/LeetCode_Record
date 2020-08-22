import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Binary_Tree_preTraversal {
// Binary Tree Preorder Traversal

    // 1. recursive
    public List<Integer> preorderTraversal_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    void helper(TreeNode root, List<Integer> res) { 
        if (root == null) return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    // 2. iterative, left children are stored to stack
    public List<Integer> preoderTraversal_iterative_left(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
            stack.push(root);
            res.add(root.val);
            root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    // iterative, right children are stored to stack
    public List<Integer> preoderTraversal_iterative_right(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            res.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            root = root.left;
            if (root == null && !stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return res;
    }

    //iterative, both children are stored to stack
    public List<Integer> preoderTraversal_iterative_both(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null) {
            res.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
            if (!stack.isEmpty())
            root = stack.pop();
            else {
                root = null;
            }
        }
        return res;
    }
}