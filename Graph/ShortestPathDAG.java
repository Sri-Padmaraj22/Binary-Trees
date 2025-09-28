package Graph;
import java.util.*;
public class ShortestPathDAG {
    class Pair{
        int first,second;

        Pair(int f,int s)
        {
            first=f;
            second=s;
        }
    }


    public int[] findShortestPath(int N,int M,int [][]graph)
    {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        int dist[]=new int[N];
        for(int i=0;i<N;i++)
        {
            ArrayList<Pair> temp=new ArrayList<>();
            adj.add(temp);
        }
        for(int i=0;i<M;i++)
        {
            int u=graph[i][0];
            int v=graph[i][1];
            int wt=graph[i][2];

            adj.get(u).add(new Pair(v,wt));
        }
        int vis[]=new int[N];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<N;i++)
        {
            if(vis[i]==0)
            dfs(i,adj,vis,st);

        }
        Arrays.fill(dist,(int)1e9);
        dist[0]=0;
        while(!st.isEmpty())
        {
            int node=st.peek();
            st.pop();
            for(int i=0;i<adj.get(node).size();i++)
            {
                int v=adj.get(node).get(i).first;
                int wt=adj.get(node).get(i).second;
                if(dist[node]+wt<dist[v]){
                    dist[v]=dist[node]+wt;
                }
            }
        }
        return dist;
    }

    public void dfs(int node,ArrayList<ArrayList<Pair>> adj,int vis[],Stack<Integer> st)
    {
        vis[node]=1;

        for(int i=0;i<adj.get(node).size();i++)
        {
            int element=adj.get(node).get(i).first;
            if(vis[element]==0)
            dfs(element,adj,vis,st);
        }
        st.push(node);
    }


    
}
