package BinarySearchTree;

public class ValidBST{
    public class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int data)
        {
            val=data;
        }
    }
    public boolean validbst(TreeNode root)
    {
        return isValidBST(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long min,long max)
    {
        if(root==null) return true;
        if(root.val<=min || root.val>=min)
        return false;

        return isValidBST(root.left,min,root.val) && isValidBST(root.right, root.val, max);

    }
}