package BinarySearchTree;

public class ConstructFromPre {
    public class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int data)
        {
            val=data;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    public TreeNode bstFromPreorder(int []preorder,int bound,int a[])
    {
        if(preorder.length==a[0]|| preorder[a[0]]>bound) return null;
        TreeNode root=new TreeNode(preorder[a[0]++]);
        root.left=bstFromPreorder(preorder,root.val,a);
        root.right=bstFromPreorder(preorder,bound,a);
        return root;
    }
}
