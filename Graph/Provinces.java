package Graph;
import java.util.*;
public class Provinces {
    

    public int find(ArrayList<ArrayList<Integer>> adj,int V)
    {
        boolean visited[]=new boolean[V];
        int count=0;

        ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++)
        {
            adjList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if(adj.get(i).get(j)==1 && i!=j)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                count++;
                dfs(visited,adjList,i);
            }
        }

        return count;
    }

    public void dfs(boolean visited[],ArrayList<ArrayList<Integer>> adj,int node)
    {
        visited[node]=true;

        for(int element: adj.get(node))
        {
            if(visited[element]!=true)
            {
                visited[element]=true;
                dfs(visited,adj,element);
            }
        }

    }
}
