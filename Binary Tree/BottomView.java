import java.util.*;
public class BottomView {
    public class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int data) {
            this.val = data;
        }
    }
    public class Pair{
        int vert;
        TreeNode node;
        Pair(TreeNode node, int vert) {
            this.node = node;
            this.vert = vert;
        }
    }

    public List<Integer> bottom(TreeNode root)
    {
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        TreeMap<Integer,Integer> map=new TreeMap<>();
        List<Integer> res=new ArrayList<>();
        if(root==null)
        return res;
        
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int vert=p.vert;
            TreeNode node=p.node;
            map.put(vert,node.val);
            if(node.left!=null)
            q.offer(new Pair(node.left,vert-1));
            if(node.right!=null)
            q.offer(new Pair(node.right,vert+1));
        }

        for(Map.Entry<Integer,Integer> m:map.entrySet())
        {
            res.add(m.getValue());
        }
        return res;
    }
}
