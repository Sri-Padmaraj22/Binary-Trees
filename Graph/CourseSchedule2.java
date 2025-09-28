package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int V, int[][] graph) {
        
        int indegree[]=new int[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        int m=graph.length;
        for(int i=0;i<m;i++)
        {
            adj.get(graph[i][1]).add(graph[i][0]);
        }
        for(int i=0;i<V;i++)
        {
            for(int element:adj.get(i))
            indegree[element]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            q.add(i);
        }
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty())
        {
            int node=q.poll();
            topo.add(node);
            for(int element:adj.get(node))
            {
                indegree[element]--;
                if(indegree[element]==0)
                {
                    q.add(element);
                }
            }
        }
        if(topo.size()!=V)
        return new int[]{};
        else
        {
            int ans[]=new int[topo.size()];
            int j=0;
            for(int i=0;i<topo.size();i++)
            {
                ans[j++]=topo.get(i);
            }
            return ans;
        }
    }
}
