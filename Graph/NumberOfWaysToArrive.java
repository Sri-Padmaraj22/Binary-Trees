package Graph;
import java.util.*;
public class NumberOfWaysToArrive
{
    class Pair
    {
        long distance;int node;
        Pair(int n,long d)
        {
            distance=d;
            node=n;
        }

    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int m=roads.length;
        for(int i=0;i<m;i++)
        {
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        long dist[]=new long[n];
        int ways[]=new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        ways[0]=1;
        dist[0]=0;
        
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)-> Long.compare(x.distance,y.distance));
        pq.add(new Pair(0,0));
        int mod=(int)(1e9+7);
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            long distance=p.distance;
            int node=p.node;
           
            for(Pair element:adj.get(node))
            {
                int adjnode=element.node;
                long dis=element.distance;
                if(dis+distance<dist[adjnode])
                {
                    dist[adjnode]=dis+distance;
                    ways[adjnode]=ways[node];
                    pq.add(new Pair(adjnode,dist[adjnode]));
                }
                else if(dis+distance==dist[adjnode])
                {
                    ways[adjnode]=(ways[adjnode]+ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}