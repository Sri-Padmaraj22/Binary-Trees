package Graph;
import java.util.*;
public class TopoSort {
    
    public ArrayList<Integer> topo(int [][]graph,int V)
    {
        int vis[]=new int[V];
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,graph,vis,st);
            }
        }
        while(!st.isEmpty())
        {
            ans.add(st.pop());
        }
        return ans;
    }
    public void dfs(int node,int[][]graph,int vis[],Stack<Integer> st)
    {
        vis[node]=1;
        
        for(int element:graph[node])
        {
            if(vis[element]==0)
            dfs(element,graph,vis,st);
        }
        st.push(node);
    }
}
