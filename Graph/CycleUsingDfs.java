package Graph;

import java.util.ArrayList;

public class CycleUsingDfs {
    
    public boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[]=new boolean[V+1];

        for(int i=0;i<V;i++)
        {
            if(vis[i]==false)
            {
            if(check(i,-1,adj,vis))
            return true;
            }
        }
        return false;
    }
    public boolean check(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean vis[])
    {
        vis[node]=true;

        for(int element:adj.get(node))
        {
            if(vis[element]==false)
            {
                if(check(element,node,adj,vis))
                return true;
            }
            else if(element!=parent)
            {
                return true;
            }
        }


        return false;
    }
}
