package BinarySearchTree;

public class Ceil {
    public class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int data)
        {
            val=data;
        }
    }

    public int ceil(TreeNode root,int val)
    {
        int ceil=-1;
        while(root!=null){
            if(val==root.val)
            {
                ceil=root.val;
                return ceil;
            }

            if(val>root.val)
            {
                root=root.right;
            }
            else{
                ceil=root.val;
                root=root.left;
            }
        }

        return ceil;
    }
}
