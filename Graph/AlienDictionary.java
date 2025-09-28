package Graph;

import java.util.*;

public class AlienDictionary
{

    public String findOrder(String []a, int N,int K)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<K;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<N-1;i++)
        {
            String S1=a[i];
            String S2=a[i+1];
            int len=Math.min(S1.length(),S2.length());
            for(int ptr=0;ptr<len;ptr++)
            {
                if(S1.charAt(ptr)!=S2.charAt(ptr))
                {
                    adj.get(S1.charAt(ptr)-'a').add(S2.charAt(ptr)-'a');
                    break;
                }
            }

        }
        List<Integer> topo=topoSort(K,adj);
        String ans="";
        for(int element:topo)
        {
            ans=ans+ (char)(element+ (int)'a');
        }
        return ans;
    }
    public List<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree=new int[V];
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<V;i++)
        {
            for(int element:adj.get(i))
            {
                indegree[element]++;
            }
        }
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            q.add(i);
        }
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.poll();
            topo.add(node);
            for(int element:adj.get(node))
            {
                indegree[element]--;
                if(indegree[element]==0)
                q.add(element);
            }

        }
        return topo;
    }
}