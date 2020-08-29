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
    // 这个方法是保存左节点，也是起到一个记录的作用
    // 从根节点直接循环到最左边的叶子节点，再取出，接着判断是右节点是否存在，存在则往右节点走，否则就弹栈
    //
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
    // 从根节点出发，读出根节点，将右节点压入栈中，再往左子树走，如果左子树的节点是空，而且栈不是空的，取出
    // 之前在栈中保存的右节点，继续循环
    // 时间复杂度：每个节点遍历一遍是N
    // 空间复杂度：只是保存右节点，所以最大需要的栈的空间是logN或者h
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