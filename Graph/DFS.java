package Graph;
import java.util.*;
public class DFS {
    
    public ArrayList<Integer> DepthFirstSearch(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[]=new boolean[V+1];
        visited[0]=true;
        ArrayList<Integer> ans=new ArrayList<>();
        findDFS(0,visited,adj,ans);
        return ans;
    }

    public void findDFS(int node,boolean visited[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans)
    {
        visited[node]=true;
        ans.add(node);

        for(int ele : adj.get(node))
        {
            if(visited[ele]==false)
            {
                findDFS(ele,visited,adj,ans);
            }
        }

    }
}
