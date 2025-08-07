public class SymmetricTree
{
    
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) 
      {this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
     }
  }
    public boolean isSymmetric(TreeNode root) {
    return root==null || issys(root.left,root.right);

    }
    public boolean issys(TreeNode left,TreeNode right)
    {
        if(left==null || right==null)
        return left==right;
        if(left.val!=right.val) return false;

        return issys(left.left,right.right) && issys(left.right,right.left);
    }

}