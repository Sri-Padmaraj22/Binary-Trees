package BinarySearchTree;
public class InorderSuccessor {
    
     public class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int data)
        {
            val=data;
        }
    }
    public TreeNode successor(TreeNode root,int val)
    {
        TreeNode successor=null;
        while(root!=null)
        {
            if(root.val<=val) root=root.right;
            else if(root.val>val)
            {
                successor=root;
                root=root.left;
            }
        
        }
        return successor;
    }
    public TreeNode predecessor(TreeNode root,int key)
    {
        TreeNode predecessor=null;
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.val<key) 
            {
                predecessor=curr;
                curr=curr.right;
            }
            else
            {
                curr=curr.left;
            }
        }
        return predecessor;
    }
   
}
