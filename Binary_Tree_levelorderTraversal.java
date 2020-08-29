import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_levelorderTraversal {
    //1 iterative
    public List<List<Integer>> levelOrder_iterative(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) return res;
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> subRes = new ArrayList<>();
            while (size-- > 0) {
            root = stack.remove();
            subRes.add(root.val);
            if (root.left != null) stack.add(root.left);
            if (root.right != null) stack.add(root.right);
            }
            res.add(subRes);
        }
        return res;
    }

    //2 recursive
    public List<List<Integer>> levelOrder_recursive(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        helper(1, root, res);
        return res;
    }
    void helper(int level, TreeNode root, List<List<Integer>> res) {
        if (res.size() < level) res.add(new ArrayList<Integer>());
        res.get(level - 1).add(root.val);
        if (root.left != null) helper(level + 1, root.left, res);
        if (root.right != null) helper(level + 1, root.right, res);
    }

}