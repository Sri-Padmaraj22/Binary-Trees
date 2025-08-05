import java.util.*;

public class BoundaryTraversal {
    public class TreeNode{
        TreeNode left,right;
        int val;

        TreeNode(int data)
        {
            this.val=data;
        }
    }
    boolean isLeaf(TreeNode node)
    {
        if(node.left == null && node.right==null)
        return true;
        return false;
    }
    void leftBoundary(TreeNode root, List<Integer> res )
    {
        TreeNode curr=root.left;
        while(curr!=null)
        {
            if(!isLeaf(curr)) res.add(curr.val);
            if(curr.left!=null)
            curr=curr.left;
            else
            curr=curr.right;
        }

    }
    void rightBoundary(TreeNode root, List<Integer> res )
    {
        TreeNode curr=root.right;
        Stack<Integer> st=new Stack<>();
        while(curr!=null)
        {
            if(!isLeaf(curr)) st.push(curr.val);
            if(curr.right!=null)
            curr=curr.right;
            else
            curr=curr.left;
        }

        while(!st.isEmpty())
        {
            res.add(st.pop());
        }
    }
    void addleaf(TreeNode root,List<Integer> res)
    {
        if(isLeaf(root))
        {
            res.add(root.val);
            return;

        }
        if(root.left!=null) addleaf(root.left,res);
        if(root.right!=null) addleaf(root.right,res);
    }
    
    public List<Integer> boundary(TreeNode root)
    {
        List<Integer> res=new ArrayList<>();
        leftBoundary(root, res);
        addleaf(root, res);
        rightBoundary(root, res);
        return res;
    }
    

    
}
