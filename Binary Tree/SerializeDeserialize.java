import java.util.*;
public class SerializeDeserialize {
     public class TreeNode{
        TreeNode left,right;
        int val;
        TreeNode(int data)
        {
            this.val=data;
        }
    }
    public String serialize(TreeNode root)
    {
        if(root==null) return " ";
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        StringBuilder ans=new StringBuilder();

        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            if(node==null)
            {ans.append("n ");
            continue;}
            ans.append(node.val+" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return ans.toString();
    }

    public TreeNode deserialize(String s)
    {
        if(s==" ") return null;
        String arr[]=s.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        for(int i=1;i<arr.length;i++)
        {
            TreeNode node=q.poll();
            if(!arr[i].equals("n "))
            {
                TreeNode left=new TreeNode((Integer.parseInt(arr[i])));
                node.left=left;
                q.offer(left);
            }
            if(!arr[++i].equals("n "))
            {
                TreeNode right=new TreeNode((Integer.parseInt(arr[i])));
                node.right=right;
                q.offer(right);
            }
        }
        return root;
    }

    
}
