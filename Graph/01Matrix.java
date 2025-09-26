package Graph;
import java.util.*;
class Solution {
    class Pair
    {
        int first,second,dist;
        Pair(int first,int second,int dist)
        {
            this.first=first;
            this.second=second;
            this.dist=dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        boolean vis[][]=new boolean[m][n];
        int ans[][]=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    vis[i][j]=true;
                    q.add(new Pair(i,j,0));
                }
                else
                {
                    vis[i][j]=false;
                }
            }
        }
   
            int delrow[]={-1,0,1,0};
            int delcol[]={0,1,0,-1};
            while(!q.isEmpty())
            {
                int row=q.peek().first;
                int col=q.peek().second;
                int dist=q.peek().dist;
                q.poll();
                ans[row][col]=dist;
                for(int i=0;i<4;i++ )
                {
                    int nrow=row+delrow[i];
                    int ncol=col+delcol[i];
                    if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && vis[nrow][ncol]==false)
                    {
                            vis[nrow][ncol]=true;
                            q.add(new Pair(nrow,ncol,dist+1));
                    }
                }
            }

        return ans;
    }
}
