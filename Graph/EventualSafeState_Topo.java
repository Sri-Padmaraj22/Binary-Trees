package Graph;

import java.util.*;

public class EventualSafeState_Topo {
     public List<Integer> eventualSafeNodes(int[][] graph)
     {
        ArrayList<ArrayList<Integer>> rev=new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<n;i++)
        {
            rev.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int element:graph[i])
            {
                rev.get(element).add(i);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        int indegree[]=new int[n];
        for(int i=0;i<n;i++)
        {
            for(int element:rev.get(i))
            {
                indegree[element]++;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            q.add(i);
        }
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty())
        {
            int node=q.poll();
            topo.add(node);
            for(int element:rev.get(node))
            {
                indegree[element]--;
                if(indegree[element]==0)
                q.add(element);

            }

        }
        return topo;

     }
}
