package Graph;
import java.util.*;
public class Enclaves {
    class Solution {
    class Pair
    {
        int first,second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int visited[][]=new int[m][n];
        int count=0;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        Queue<Pair> q=new LinkedList<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==0 || i==m-1 || j==n-1)
                {
                    if(grid[i][j]==1)
                    {
                        visited[i][j]=1;
                        q.add(new Pair(i,j));
                    }
                }
            }
        }
        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col=q.peek().second;
            q.poll();

            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];

                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && visited[nrow][ncol]==0 && grid[nrow][ncol]==1)
                {
                    visited[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]==0 && grid[i][j]==1)
                count++;
            }
        }
        return count;

    }
}
}
