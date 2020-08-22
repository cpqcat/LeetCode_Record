import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Binary Tree Preorder Traversal

class Binary_Tree_Traversal {
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

    // 2. iterative
    public List<Integer> preoderTraversal_iterative(TreeNode root) {
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

}