package Graph;
import java.util.*;
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];

        Arrays.fill(color,-1);

        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(!check(i,graph,color))
                return false;
            }
        }
        return true;

    }
    public boolean check(int start,int graph[][],int color[])
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        color[start]=0;

        while(!q.isEmpty())
        {
            int node=q.peek();
            q.poll();
            for(int element:graph[node])
            {
                if(color[element]==-1)
                {
                    color[element]=1-color[node];
                    q.add(element);
                }
                else if(color[node]==color[element])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
