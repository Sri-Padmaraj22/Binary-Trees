package Graph;
import java.util.*;
public class ShortestPathUndirected {
    public int[]  shortestPath(int N,int M,int graph[][],int src)
    {
        int dist[]=new int[N];
        Arrays.fill(dist,(int)1e9);
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++)
        {
            int u=graph[i][0];
            int v=graph[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        dist[src]=0;
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.poll();
            for(int element:adj.get(node))
            {
                if(dist[node]+1<dist[element])
                dist[element]=dist[node]+1;
                q.add(element);
            }
        }

        for(int i=0;i<N;i++)
        {
            if(dist[i]==(int)1e9)
            dist[i]=-1;
        }




        return dist;
    }
}
