public class Validate_Binary_Search_Tree {
    boolean flag;
    long pre;
    public boolean isValidBST(TreeNode root) {
        pre = Long.MIN_VALUE;
        flag = true;
        helper(root); 
        return flag;  
    }
    void helper(TreeNode root) {
        if (root == null) return;
        if (flag == true)
        helper(root.left);

        if (pre < root.val)
        pre = root.val;
        else {
            flag = false;
        }

        if (flag == true)
        helper(root.right);

    }   
}