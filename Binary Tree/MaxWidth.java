import java.util.*;
public class MaxWidth {
     public class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int data) {
            this.val = data;
        }
    }
    public class Pair{
        int index;
        TreeNode node;
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int maxWidth(TreeNode root)
    {
        int width=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        if(root==null)
        return 1;
        while(!q.isEmpty())
        {
            int size=q.size();
            int min=q.peek().index;
            int first=0,last=0;
            for(int i=0;i<size;i++)
            {
                int id=q.peek().index-min;
                TreeNode node=q.peek().node;
                q.poll();
                if(i==0)
                first=id;
                if(i==(size-1))
                last=id;
                if(node.left!=null)
                q.offer(new Pair(node,id*2+1));
                if(node.right!=null)
                q.offer(new Pair(node,2*id+2));

            }
            width=Math.max(width,last-first+1);
        }
        return width;
    }
}
