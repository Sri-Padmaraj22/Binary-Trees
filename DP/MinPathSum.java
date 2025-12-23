package DP;

public class MinPathSum {
  public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return minPathSum(m-1,n-1,grid,dp);
        //return minPathSum3(grid);
    }
    //Memoization
    public int minPathSum(int i,int j,int grid[][],int dp[][])
    {
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=minPathSum(i-1,j,grid,dp)+grid[i][j];
        int left=minPathSum(i,j-1,grid,dp)+grid[i][j];
        return dp[i][j]=Math.min(up,left);
    }
    //Tabulation
    public int minPathSum2(int[][] grid)
    {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0) dp[0][0]=grid[0][0];
                else
                {
                    int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
                    if(i>0)
                    up=grid[i][j]+dp[i-1][j];
                    if(j>0)
                    left=grid[i][j]+dp[i][j-1];

                    dp[i][j]=Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
    //Space Optimization
    public int minPathSum3(int[][] grid)
    {
        int m=grid.length;
        int n=grid[0].length;
        int dp[]=new int[n];
        for(int i=0;i<m;i++)
        { int temp[]=new int[n];
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0) temp[0]=grid[0][0];
                else
                {
                    int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
                    if(i>0)
                    up=grid[i][j]+dp[j];
                    if(j>0)
                    left=grid[i][j]+temp[j-1];

                    temp[j]=Math.min(up,left);
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }
}
