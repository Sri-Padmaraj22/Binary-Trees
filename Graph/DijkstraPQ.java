package Graph;
import java.util.*;
public class DijkstraPQ {
    class Pair{
        int distance;
        int second;
        Pair(int distance, int second)
        {
            this.distance=distance;
            this.second=second;
        }
    }
    
    public int[] ShortestPath(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj,int S)
    {
        int dist[]=new int[V];
        Arrays.fill(dist,(int)1e9);
        PriorityQueue<Pair> q=new PriorityQueue<Pair>((x,y)-> x.distance-y.distance);
        q.add(new Pair(0,S));
        dist[S]=0;
        while(!q.isEmpty())
        {
            int node=q.peek().second;
            int distance=q.peek().distance;
            q.poll();
            for(int i=0;i<adj.get(node).size();i++)
            {
                int wt=adj.get(node).get(i).get(1);
                int adjnode=adj.get(node).get(i).get(0);
                if(distance+wt<dist[adjnode])
                {
                    dist[adjnode]=wt+distance;
                    q.add(new Pair(dist[adjnode],adjnode));
                }
            }


        }



        return dist;
    }
}
