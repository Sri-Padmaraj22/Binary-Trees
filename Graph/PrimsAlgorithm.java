package Graph;
import java.util.*;
public class PrimsAlgorithm {
    static class Pair{
        int node;int distance;

        Pair(int distance,int node)
        {
            this.node=node;
            this.distance=distance;
        }
    }
    
    static int spanningTree(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        int sum=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)-> x.distance-y.distance);
        int vis[]=new int[V];
        pq.add(new Pair(0,0));

        while(!pq.isEmpty())
        {
            int node=pq.peek().node;
            int wt=pq.peek().distance;
            if(vis[node]==1)
            continue;
            sum+=wt;
            vis[node]=1;
            for(int i=0;i<adj.get(node).size();i++)
            {
                int adjwt=adj.get(node).get(i).get(1);
                int adjnode=adj.get(node).get(i).get(0);
                if(vis[adjnode]==0)
                {
                    pq.add(new Pair(adjwt,adjnode));
                }
            }
        }
        return sum;
    }
}
