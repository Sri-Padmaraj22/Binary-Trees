package Graph;
import java.util.*;
public class KruskalAlgorithm {
    class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<n;i++)
       {rank.add(0);
        parent.add(i);
        size.add(1);}
    }

    public int findUlp(int node)
    {
        if(node==parent.get(node))
        return node;
        int ulp=findUlp(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void UnionByRank(int u,int v)
    {
        int ulp_u=findUlp(u);
        int ulp_v=findUlp(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u)<rank.get(ulp_v))
        parent.set(ulp_u,ulp_v);
        else if(rank.get(ulp_v)<rank.get(ulp_u))
        parent.set(ulp_v,ulp_u);
        else{
            parent.set(ulp_v,ulp_u);
            int rankU=rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
    public void UnionBySize(int u,int v)
    {
        int ulp_u=findUlp(u);
        int ulp_v=findUlp(v);
        if(ulp_u==ulp_v) return ;
        if(size.get(ulp_u)<size.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }

    }
}
}
        class Edge implements Comparable<Edge>{
            int src,dest,wt;
            Edge(int src,int dest,int wt)
            {
                this.src=src;
                this.dest=dest;
                this.wt=wt;
            }
            public boolean compareTo(Edge compare)
            {
                return this.wt-compare.wt<0;
            }
        }

        public int kruskal(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj)
        {
            int sum=0;
            List<Edge> edges=new ArrayList<>();
            for(int i=0;i<V;i++)
            {
                for(int j=0;j<adj.get(i).size();i++)
                {
                    int adjnode=adj.get(i).get(j).get(0);
                    int wt=adj.get(i).get(j).get(1);
                    int node=i;
                    Edge edge=new Edge(node,adjnode,wt);
                    edges.add(edge);
                }
            }
            DisjointSet dj=new DisjointSet(V);
            Collections.sort(edges);
            for(int i=0;i<edges.size();i++)
            {
                int wt=edges.get(i).wt;
                int node=edges.get(i).src;
                int adjnode=edges.get(i).dest;

                if(dj.findUlp(node)!=dj.findUlp(adjnode))
                {
                    sum+=wt;
                    dj.UnionBySize(node,adjnode);
                }
            }
            return sum;
        }
}
