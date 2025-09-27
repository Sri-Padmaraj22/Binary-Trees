package Graph;

import java.util.ArrayList;

public class DirectedCycle {
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj,int V)
    {
        int vis[]=new int[V];
        int pathvis[]=new int[V];

        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                if(dfs(i,vis,pathvis,adj)==true)
                return true;
            }
        }
        return false;
    }
    public boolean dfs(int start,int vis[],int pathvis[],ArrayList<ArrayList<Integer>> adj)
    {
        vis[start]=1;
        pathvis[start]=1;

        for(int element:adj.get(start))
        {
            if(vis[element]==0)
            {
                if(dfs(element,vis,pathvis,adj))
                return true;
            }
            else if(pathvis[element]==1)
            return true;
        }
        pathvis[start]=0;
        return false;

    }
}
