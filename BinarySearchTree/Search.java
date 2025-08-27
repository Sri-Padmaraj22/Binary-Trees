package BinarySearchTree;
public class Search
{
    public class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int data)
        {
            val=data;
        }
    }

    public TreeNode search(TreeNode root,int val)
    {
        if(root==null)
        return null;
        if(val==root.val)
        return root;
        if(val>root.val)
        return search(root.right,val);
        return search(root.left,val);
    }
    public TreeNode search1(TreeNode root,int val)
    {
        while(root!=null && root.val!=val)
        {
            root=(val>root.val)?root.right: root.left;
        }
        return root;
    }
}