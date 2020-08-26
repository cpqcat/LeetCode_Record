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
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            // only add to the result when left sub tree is null
            if (cur.left == null) result.add(cur.val);
            else {
                // if left sub tree is no null, we need to
                // add it back to the stack, but after its left sub tree.
                // then set the left subtree to null.(next time we can
                // add it)
                stack.push(cur);
                stack.push(cur.left);
                cur.left = null;
                cur.right = null;// we also need to cut the right subtree.
            }
            
        }
        
        return result;
    }

}