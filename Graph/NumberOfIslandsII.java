package Graph;
import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
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

        public ArrayList<Integer> islands(int m,int n,int operators[][])
        {
            ArrayList<Integer> adj=new ArrayList<>();
            DisjointSet ds=new DisjointSet(m*n);
            int count=0;
            int vis[][]=new int[m][n];
            int len=operators.length;
            for(int i=0;i<len;i++)
            {
                int row=operators[i][0];
                int col=operators[i][1];

                if(vis[row][col]==1)
                {
                    adj.add(count);
                    continue;
                }
                vis[row][col]=1;
                count++;


                int delrow[]={-1,0,1,0};
                int delcol[]={0,1,0,-1};

                for(int j=0;j<4;j++)
                {
                    int adjrow=row+delrow[i];
                    int adjcol=col+delcol[i];

                    if(isValid(adjrow,adjcol,n,m))
                    {
                        if(vis[adjrow][adjcol]==1)
                        {
                            int node=row*m+col;
                            int adjnode=adjrow*m+adjcol;

                            if(ds.findUlp(node)!=ds.findUlp(adjnode))
                            {
                                count--;
                                ds.UnionBySize(node, adjnode);
                            }
                        }
                    }
                }

                adj.add(count);
            }
            return adj;
            
        }

        public boolean isValid(int adjrow,int adjcol,int n,int m )
        {
            return adjrow<n && adjrow>=0 && adjcol<m && adjcol>=0;
        }
}
