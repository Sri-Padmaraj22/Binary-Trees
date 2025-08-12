import java.util.*;
public class PostInTree {
    public class TreeNode{
        TreeNode left,right;
        int val;
        TreeNode(int data)
        {
            this.val=data;
        }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root=buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    public TreeNode buildTree(int post[],int poststart,int postend,int in[],int instart,int inend,Map<Integer,Integer> map)
    {
        if(instart>inend || poststart>postend) return null;

        TreeNode root=new TreeNode(post[postend]);
        int rootlevel=map.get(post[postend]);
        int numsleft=rootlevel-instart;
        root.left=buildTree(post,poststart,poststart+numsleft-1,in,instart,rootlevel-1,map);
        root.right=buildTree(post,poststart+numsleft,postend-1,in,rootlevel+1,inend,map);

        return root;

    }
}
