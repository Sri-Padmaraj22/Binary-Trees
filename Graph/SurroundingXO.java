package Graph;

public class SurroundingXO {
    
    public void dfs(int row,int col,char[][]grid,int vis[][],int delrow[],int delcol[])
    {   int m=grid.length;
        int n=grid[0].length;
        vis[row][col]=1;
        for(int i=0;i<4;i++)
        {
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && ncol>=0 && nrow<m && ncol<n)
            {
                if(vis[nrow][ncol]==0)
                dfs(nrow,ncol,grid,vis,delrow,delcol);
            }
        }
    }

    public void XO(char [][]grid)
    {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};

        for(int i=0;i<m;i++)
        {
            if(vis[i][0]==0 && vis[i][0]=='O')
            dfs(i,0,grid,vis,delrow,delcol);

            if(vis[i][m-1]==0 && vis[i][m-1]=='O')
            dfs(i,m-1,grid,vis,delrow,delcol);
        }
        for(int i=0;i<n;i++)
        {
            if(vis[0][i]==0 && vis[0][i]=='O')
            dfs(0,i,grid,vis,delrow,delcol);

            if(vis[n-1][i]==0 && vis[n-1][i]=='O')
            dfs(n-1,i,grid,vis,delrow,delcol);
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='O')
                grid[i][j]='X';
            }
        }

    }
}
