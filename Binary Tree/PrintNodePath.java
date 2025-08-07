import java.util.*;
public class PrintNodePath {
     public class TreeNode{
        TreeNode left,right;
        int val;

        TreeNode(int data)
        {
            this.val=data;
        }
    }

    public List<Integer> print(TreeNode root,TreeNode node)
    {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        find(root,node,res);
        return res;
    }
    public boolean find(TreeNode root,TreeNode node,List<Integer> res)
    {
        if(root==null)
        return false;
        res.add(root.val);
        if(root.val==node.val)
        return true;
        if(find(root.left,node,res)|| find(root.right,node,res))
        return true;
        res.remove(res.size()-1);


        return false;
    }
}
