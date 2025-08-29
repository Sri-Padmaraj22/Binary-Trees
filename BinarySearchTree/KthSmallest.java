package BinarySearchTree;
import java.util.ArrayList;

public class KthSmallest {
    public class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int data)
        {
            val=data;
        }
    }
    ArrayList<Integer> res=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans=inorder(root);
        return ans.get(k-1);
    }
    public ArrayList<Integer> inorder(TreeNode root)
    {
        if(root!=null)
        {
            inorder(root.left);
            res.add(root.val);
            inorder(root.right);
        }
        return res;
    }
}
