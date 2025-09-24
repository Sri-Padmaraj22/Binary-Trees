package Graph;
import java.util.*;
public class BFS {
    
    public ArrayList<Integer> BreadthFirstSearch(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Queue <Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[V+1];
        ArrayList<Integer> ans=new ArrayList<>();
        q.add(0);
        visited[0]=true;

        while(!q.isEmpty())
        {
            int node=q.poll();
            ans.add(node);

            for(int neighbour:adj.get(node))
            {
                if(visited[neighbour]==false)
                {
                    visited[neighbour]=true;
                    q.add(neighbour);
                }
            }
        }

        return ans;



    }
}
