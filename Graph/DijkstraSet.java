package Graph;
import java.util.*;
public class DijkstraSet {
    class Pair implements Comparable<Pair>
    {
        int distance, node;
        Pair(int distance,int node)
        {
            this.distance=distance;
            this.node=node;
        }
        public int compareTo(Pair other)
        {
            if(this.distance==other.distance)
            return this.node-other.node;
            return this.distance-other.distance;

        }
    }
    public int[] shortestPath(ArrayList<ArrayList<ArrayList<Integer>>> adj,int V,int src)
    {
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        TreeSet<Pair> set=new TreeSet<>();
        set.add(new Pair(0,src));

        while(!set.isEmpty())
        {
            Pair pair=set.pollFirst();
            int node=pair.node;
            int distance=pair.distance;
            for(int i=0;i<adj.get(node).size();i++)
            {
                int wt=adj.get(node).get(i).get(1);
                int adjnode=adj.get(node).get(i).get(0);

                if(distance+wt<dist[adjnode])
                {
                    if(dist[adjnode]!=Integer.MAX_VALUE)
                    set.remove(new Pair(dist[adjnode],adjnode));
                    dist[adjnode]=distance+wt;
                    set.add(new Pair(dist[adjnode],node));
                }
            }
            
        }


        return dist;

    }
}
