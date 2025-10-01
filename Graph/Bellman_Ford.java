package Graph;
import java.util.*;
public class Bellman_Ford {
    
    public static int[] bellman(int S,int V,ArrayList<ArrayList<Integer>> edges)
    {
        int dist[]=new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[S]=0;
        for(int i=0;i<V-1;i++)
        {
            for(ArrayList<Integer> element:edges)
            {
                int u=element.get(0);
                int v=element.get(1);
                int wt=element.get(2);

                if(dist[u]!=(int)1e9 && dist[u]+wt<dist[v])
                {
                    dist[v]=dist[u]+wt;
                }
            }
        }

        for(ArrayList<Integer> element: edges)
        {
            int u=element.get(0);
                int v=element.get(1);
                int wt=element.get(2);
                if(dist[u]!=(int)1e9 && dist[u]+wt<dist[v])
                {
                    int[] temp=new int[1];
                    temp[0]=-1;
                    return temp;
                }


        }


        return dist;
    }
}
