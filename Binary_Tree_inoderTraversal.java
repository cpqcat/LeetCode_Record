import java.util.ArrayList;
import java.util.HashMap;
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
        return res;
    }

    // 3.iterative right children are stored to stack 
    // may be not right
     
    List<Integer> inorderTraversal_iterative_right(TreeNode root) {
        List<Integer> result = new ArrayList<>();
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

    // 4. iterative both children are stored to stack, color flag
    List<Integer> inorderTraversal_iteratvie_both(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode,Integer> map = new HashMap<>();
        if (root == null) return res;
        stack.push(root);
        map.put(root, 1);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (1 == map.get(node)) {
                if (node.right != null) {
                    stack.push(node.right);
                    map.put(node.right, 1);
                }
                
                stack.push(node);
                map.put(node, 2);

                if (node.left != null) {
                    stack.push(node.left);
                    map.put(node.left, 1);
                }
            }
            else {
                res.add(node.val);
            }
        }
        return res;
    }
}