import java.util.*;
public class RightSideView {
    public class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int data) {
            this.val = data;
        }
    }

    public List<Integer> solution(TreeNode root)
    {
        List<Integer> res=new ArrayList<>();
        right(root,res,0);
        return res;
    }
    public void right(TreeNode root,List<Integer> res,int level)
    {
        if(root!=null)
        {
            if(level==res.size())
            res.add(root.val);
            right(root.right,res,level+1);
            right(root.left,res,level+1);
        }
    }
}
