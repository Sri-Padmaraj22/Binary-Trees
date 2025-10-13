import java.util.ArrayList;
import java.util.List;

public class NoOfOperationsToConnectProvinces {
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
    public int makeConnected(int n, int[][] connections) {
     int m=connections.length;   
     int extraedges=0;
     DisjointSet ds=new DisjointSet(n);
     for(int i=0;i<m;i++)
     {
        int u=connections[i][0];
        int v=connections[i][1];
        if(ds.findUlp(u)==ds.findUlp(v))
        extraedges++;
        else
        ds.UnionBySize(u,v);
     }
     int nC=0;
     for(int i=0;i<n;i++)
     {
        if(ds.parent.get(i)==i) nC++;
     }
     int ans=nC-1;
     if(extraedges>=ans)
     return ans;
     else
     return -1;
    }
}

