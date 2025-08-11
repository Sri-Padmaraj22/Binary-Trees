import java.util.*;
public class MinimumTimeToBurn {
    class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val)
        {
            this.val=val;
            left=right=null;
        }
    }
    public void markParent(TreeNode root,Map<TreeNode,TreeNode> map){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            if(node.left!=null)
            {
                map.put(node.left,node);
                q.offer(node);
            }
            if(node.right!=null)
            {
                map.put(node.right,node);
                q.offer(node);
            }
        }

    }
    public int distance(TreeNode root,TreeNode node)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(node);
        Map<TreeNode,TreeNode> map=new HashMap<>();
        markParent(root, map);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        int dis=0;
        visited.put(node,true);
        while(!q.isEmpty())
        {
            int size=q.size();
            int flag=0;

            for(int i=0;i<size;i++)
            {
                TreeNode n=q.poll();
                if(n.left!=null && visited.get(n.left)==null)
                {
                    flag=1;
                    q.offer(n.left);
                    visited.put(n.left,true);

                }
                if(n.right!=null && visited.get(n.right)==null)
                {
                    flag=1;
                    q.offer(n.right);
                    visited.put(n.right,true);
                }
                if(map.get(n)!=null && visited.get(map.get(n))==null)
                {
                    flag=1;
                    q.offer(map.get(n));
                    visited.put(map.get(n),true);

                }
            }
            if(flag==1) dis++;
        }

        return dis;

    }
}
