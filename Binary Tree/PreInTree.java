import java.util.*;
public class PreInTree {
    public class TreeNode{
        TreeNode left,right;
        int val;
        TreeNode(int data)
        {
            this.val=data;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<preorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root=buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    public TreeNode buildTree(int []preorder,int pstart,int pend,int inorder[],int instart,int inend,Map<Integer,Integer> map)
    {
        if(pstart>pend || instart>inend) return null;

        TreeNode root=new TreeNode(preorder[pstart]);
        int rootlevel=map.get(root.val);
        int numsleft=rootlevel-instart;
        root.left=buildTree(preorder,pstart+1,pstart+numsleft,inorder,instart,rootlevel-1,map);
        root.right=buildTree(preorder,pstart+numsleft+1,pend,inorder,rootlevel+1,inend,map);
        return root;
    }
    
}
