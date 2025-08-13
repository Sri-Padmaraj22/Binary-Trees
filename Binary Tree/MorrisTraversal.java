import java.util.*;
public class MorrisTraversal {
     class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val)
        {
            this.val=val;
            left=right=null;
        }
    }
    public ArrayList<Integer> inorder(TreeNode root)
    {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null)
        return list;

        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                list.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev=curr.right;
                }
                if(prev.right==null)
                {
                    prev.right=curr;
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    list.add(prev.val);
                    curr=curr.right;
                }
            }
        }
        return list;
    }
     public ArrayList<Integer> preorder(TreeNode root)
    {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null)
        return list;

        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                list.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev=curr.right;
                }
                if(prev.right==null)
                {
                    prev.right=curr;
                    list.add(prev.val);
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    curr=curr.right;
                }
            }
        }
        return list;
    }
}
