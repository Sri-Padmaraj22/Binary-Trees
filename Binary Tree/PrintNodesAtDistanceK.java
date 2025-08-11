import java.util.*;
public class PrintNodesAtDistanceK {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public void markParent(TreeNode root,Map<TreeNode,TreeNode> map)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            if(node.left!=null)
            {
                q.offer(node.left);
                map.put(node.left,node);
            }
            if(node.right!=null)
            {
                q.offer(node.right);
                map.put(node.right,node);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map=new HashMap<>();
        markParent(root,map);
        Queue<TreeNode> q=new LinkedList<>();
        Map<TreeNode,Boolean> visited=new HashMap<>();
        q.offer(target);
        visited.put(target,true);

        int level=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            if(level==k)
            break;
            level++;

            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(node.left!=null && visited.get(node.left)==null)
                {
                    q.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null)
                {
                    q.offer(node.right);
                    visited.put(node.right,true);
                }
                if(map.get(node)!=null && visited.get(map.get(node))==null)
                {
                    q.offer(map.get(node));
                    visited.put(map.get(node),true);
                }

            }

        }
        List<Integer> l=new ArrayList<>();
        while(!q.isEmpty())
        {
            l.add(q.poll().val);
        }
        return l;
    }
}
    

