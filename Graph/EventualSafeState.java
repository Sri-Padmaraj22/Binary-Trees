package Graph;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeState {
     public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int vis[]=new int[n];
        int check[]=new int[n];
        int pathvis[]=new int[n];

        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,graph,vis,check,pathvis);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(check[i]==1)
            ans.add(i);
        }
        return ans;
    }
    public boolean dfs(int node,int graph[][],int vis[],int check[],int pathvis[])
    {
        check[node]=0;
        vis[node]=1;
        pathvis[node]=1;

        for(int element:graph[node])
        {
            if(vis[element]==0)
            {
                if(dfs(element,graph,vis,check,pathvis))
                {
                    check[element]=0;
                    return true;
                }
            }
            else if(pathvis[element]==1){
                check[element]=0;
            return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
}
