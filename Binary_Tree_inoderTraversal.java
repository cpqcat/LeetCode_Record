import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_inoderTraversal {
    List<Integer> inoderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;    
    }
    void helper(TreeNode node, List<Integer> res) {
        helper(node.left, res);
        res.add(node.val);
        helper(node.right, res);
    }
}