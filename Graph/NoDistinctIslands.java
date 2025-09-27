package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class NoDistinctIslands {

    public int count(int [][] grid)
    {
        int m=grid.length;
        int n=grid[0].length;
        HashSet<ArrayList<String>> s=new HashSet<>();
        int vis[][]=new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(vis[i][j]==0 && grid[i][j]==1)
                {
                    ArrayList<String> a=new ArrayList<>();
                    dfs(i,j,a,grid,vis,i,j);
                    s.add(a);
                }
            }
        }
        return s.size();
    }
    public void dfs(int row,int col,ArrayList<String> a, int grid[][],int vis[][],int row0,int col0)
    {
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        vis[row][col]=1;
        int m=grid.length;
        int n=grid[0].length;
        a.add(toString(row-row0,col-col0));

        for(int i=0;i<4;i++)
        {
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
            {
                dfs(nrow,ncol,a,grid,vis,row0,col0);
            }
        }


    }
    public String toString(int r,int c)
    {
        return Integer.toString(r) +" "+ Integer.toString(c);
    }
}
