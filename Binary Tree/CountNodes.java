

public class CountNodes {
    class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val)
        {
            this.val=val;
            left=right=null;
        }
    }
    public int countNodes(TreeNode root) {
        
        if(root==null)
        return 0;
        int left=countleft(root);
        int right=countright(root);

        if(left==right)
        return ((2<<(left))-1);
        else
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    public int countleft(TreeNode root)
    {
        int count=0;
        while(root.left!=null)
        {
            root=root.left;
            count++;
        }
        return count;
    }
    public int countright(TreeNode root)
    {
        int count=0;
        while(root.right!=null)
        {
            root=root.right;
            count++;
        }
        return count;
    }
}
