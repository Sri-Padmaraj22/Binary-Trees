package Graph;
import java.util.*;
public class CycleUsingBfs {
    class Pair
    {
        int first,second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }

    public boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[]=new boolean[V+1];

        for(int i=0;i<V;i++)
        {
            if(vis[i]==false)
            {
            if(check(i,V,adj,vis))
            return true;
            }
        }
        return false;
    }
    public boolean check(int src,int V,ArrayList<ArrayList<Integer>> adj,boolean vis[])
    {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,-1));
        vis[src]=true;

        while(!q.isEmpty())
        {
            int node=q.peek().first;
            int parent=q.peek().second;
            q.poll();

            for(int element: adj.get(node))
            {
                if(vis[element]==false)
                {
                    vis[element]=true;
                    q.add(new Pair(element,node));
                }
                else if(element!=parent)
                {
                    return true;
                }
            }
        }
        return false;
        
    }
}
