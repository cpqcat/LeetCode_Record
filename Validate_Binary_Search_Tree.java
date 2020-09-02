public class Validate_Binary_Search_Tree {
    //用一个中序遍历求解
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


    //递归求解，根节点一定大于左子树，小于右子树，思考这个问题自己总是要把左子树的最大值找出来和根节点比较
    //实际不用这样，根节点和左孩子节点比较，然后左孩子节点和左孩子节点的左孩子比较，通过局部的传递性，就可
    //以构成一棵二叉搜索树，就像多米诺古牌，第一张推得倒第二张，第二张推得倒第三张。。。，最终全部可以推倒

    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        if (low != null && root.val <= low) return false;
        if (high != null && root.val >= high) return false;

        if(!helper(root.left, low, root.val)) return false;
        if(!helper(root.right, root.val, high)) return false;
        return true;
    }
