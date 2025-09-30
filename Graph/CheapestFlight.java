package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlight {
    class Pair{
        int to,price;
        Pair(int to,int price)
        {
            this.to=to;
            this.price=price;
        }
    }
    class Tuple
    {
        int first;int second;int third;
        Tuple(int first,int second,int third)
        {
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        int dist[]=new int[n];
        for(int i=0;i<n;i++) dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(0,src,0));
        while(!q.isEmpty())
        {
            Tuple t=q.poll();
            int steps=t.first;
            int node=t.second;
            int weight=t.third;
            if(steps>k) continue;
            for(Pair element:adj.get(node))
            {
                int adjnode=element.to;
                int price=element.price;
                if(weight+price<dist[adjnode] && steps<=k)
                {

                    dist[adjnode]=weight+price;
                    q.add(new Tuple(steps+1,adjnode,dist[adjnode]));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];

    }
}
