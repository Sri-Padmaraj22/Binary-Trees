package BinarySearchTree;

public class Delete {
    public class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int data)
        {
            val=data;
        }
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key)
        return helper(root);
        TreeNode dummy=root;
        while(root!=null)
        {
            if(root.val>key)
            {
                if(root.left!=null && root.left.val==key)
                {
                    root.left=helper(root.left);
                    break;
                }
                else
                {
                    root=root.left;
                }
            }
            else
            {
                if(root.right!=null && root.right.val==key)
                {
                    root.right=helper(root.right);
                    break;
                }
                else
                {
                    root=root.right;
                }
            }
        }
        return dummy;
    }
    public TreeNode helper(TreeNode root)
    {
        if(root.right==null)
        return root.left;
        else if(root.left==null)
        return root.right;
        else
        {
            TreeNode rightchild=root.right;
            TreeNode lastrightnode=findLastRight(root.left);
            lastrightnode.right=rightchild;
        }
        return root.left;
    }
    public TreeNode findLastRight(TreeNode root)
    {
        if(root.right!=null)
        return findLastRight(root.right);
        return root;
    }
}
