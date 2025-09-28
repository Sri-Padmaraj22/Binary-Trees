package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedCycleBFS {

    public boolean topoSort(int V, List<List<Integer>> adj)
    {
        int[] indegree=new int[V];
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<V;i++)
        {
            for(int element:adj.get(i))
            {
                indegree[element]++;
            }
        }
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            q.add(i);
        }
        int count=0;
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.poll();
            count++;
            for(int element:adj.get(node))
            {
                indegree[element]--;
                if(indegree[element]==0)
                q.add(element);
            }

        }
        return (count==V)?false:true;
    }
    
}
