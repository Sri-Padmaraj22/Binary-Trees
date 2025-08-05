import java.util.*;

public class VerticalTraversal {
    public class TreeNode{
        TreeNode left,right;
        int val;

        TreeNode(int data)
        {
            this.val=data;
        }
    }
    public class Tuple
    {
        int vert,level;
        TreeNode node;
        Tuple(TreeNode node,int vert,int level)
        {
            this.node=node;
            this.vert=vert;
            this.level=level;
        }
    }

    public List<List<Integer>> traversal(TreeNode root)
    {
        List<List<Integer>> res=new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty())
        {
            Tuple tuple=q.poll();
            int vert=tuple.vert;
            int level=tuple.level;
            TreeNode node=tuple.node;

            if(!map.containsKey(vert))
            map.put(vert,new TreeMap<>());
            if(!map.get(vert).containsKey(level))
            map.get(vert).put(level,new PriorityQueue<>());
            map.get(vert).get(level).offer(node.val);
            if(node.left!=null)
            q.offer(new Tuple(root.left,vert-1,level+1));
            if(node.right!=null)
            q.offer(new Tuple(root.right,vert+1,level+1));
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values())
        {
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:ys.values())
            {
                res.get(res.size()-1).add(nodes.poll());
            }
        }


        return res;
        
    }
}

