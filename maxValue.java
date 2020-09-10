import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class maxValue {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            if (root == null) return res;
            queue.push(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int maxValue = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    if (node.val > maxValue) maxValue = node.val;
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                    res.add(maxValue);
            }
            return res;
        }
}