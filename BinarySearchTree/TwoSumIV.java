package BinarySearchTree;
import java.util.*;
public class TwoSumIV {
    class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val)
        {
            this.val=val;
            left=right=null;
        }
    }
public class BSTIterator{
    boolean reverse=true;
    Stack<TreeNode> st=new Stack<>();
    BSTIterator(TreeNode root,boolean reverse)
    {
        this.reverse=reverse;
        pushAll(root);
    }
    public boolean hasNext()
    {
        return !st.isEmpty();
    }
    public int next()
    {
        TreeNode node=st.pop();
        if(reverse==true) pushAll(node.left);
        else pushAll(node.right);
        return node.val;
    }
    public void pushAll(TreeNode node)
    {
        while(node!=null)
        {
            st.push(node);
            if(reverse==true)
            node=node.right;
            else
            node=node.left;

        }
    }

 }

    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);
        int i=l.next();
        int j=r.next();

        while(i<j)
        {
            if(i+j==k) return true;
            if(i+j<k) i=l.next();
            else
            j=r.next();
        }
        return false;

    }
}