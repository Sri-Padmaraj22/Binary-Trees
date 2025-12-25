package DP;

public class CherryPickupII {
  public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //m x n grid
        int dp[][][]=new int[m][n][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                dp[i][j][k]=-1;
            }
        }
        //return helper(0,0,n-1,grid,dp);
        return cherryPickup2(grid);
    }
    //Memoization
    public int helper(int i,int j1,int j2,int grid[][],int dp[][][])
    {
        int n=grid.length;
        int m=grid[0].length;
        if(j1<0 || j2<0 || j1>=m || j2>=m)
        {
            return (int)(-1e9);
        }
        if(i==n-1)
        {
            if(j1==j2)
            return grid[i][j1];
            else
            return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int max=(int)(-1e8);
        for(int dj1=-1;dj1<=1;dj1++)
        {
            for(int dj2=-1;dj2<=1;dj2++)
            {
                int value=0;
                if(j1==j2)
                value+=grid[i][j1];
                else
                value+=grid[i][j1]+grid[i][j2];

                value+=helper(i+1,j1+dj1,j2+dj2,grid,dp);
                max=Math.max(max,value);
            }
        }
        return dp[i][j1][j2]=max;
    }

    public int cherryPickup2(int[][] grid)
    {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][][]=new int[m][n][n];
        for(int j1=0;j1<n;j1++)
        {
            for(int j2=0;j2<n;j2++)
            {
                if(j1!=j2)
                dp[m-1][j1][j2]=grid[m-1][j1]+grid[m-1][j2];
                else
                dp[m-1][j1][j2]=grid[m-1][j1];
            }
        }
        for(int i=m-2;i>=0;i--)
        {
            for(int j1=0;j1<n;j1++)
            {
                for(int j2=0;j2<n;j2++)
                {
                    int max=(int)-1e9;
                     for(int dj1=-1;dj1<=1;dj1++)
                        {
                            for(int dj2=-1;dj2<=1;dj2++)
                            {
                                int value=0;
                                if(j1==j2)
                                value+=grid[i][j1];
                                else
                                value+=grid[i][j1]+grid[i][j2];
                                if(j1+dj1>=0 && j1+dj1<n && j2+dj2>=0 && j2+dj2<n)
                                value+=dp[i+1][j1+dj1][j2+dj2];
                                else
                                value+=(int)-1e9;
                                max=Math.max(max,value);
                            }
                        }
                        dp[i][j1][j2]=max;
                }
            }
        }
        return dp[0][0][n-1];
    }
    //Space Optimized
    public int cherryPickup3(int[][] grid)
    {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[n][n];
        for(int j1=0;j1<n;j1++)
        {
            for(int j2=0;j2<n;j2++)
            {
                if(j1!=j2)
                dp[j1][j2]=grid[m-1][j1]+grid[m-1][j2];
                else
                dp[j1][j2]=grid[m-1][j1];
            }
        }
        for(int i=m-2;i>=0;i--)
        {
            int temp[][]=new int[n][n];
            for(int j1=0;j1<n;j1++)
            {
                for(int j2=0;j2<n;j2++)
                {
                    int max=(int)-1e9;
                     for(int dj1=-1;dj1<=1;dj1++)
                        {
                            for(int dj2=-1;dj2<=1;dj2++)
                            {
                                int value=0;
                                if(j1==j2)
                                value+=grid[i][j1];
                                else
                                value+=grid[i][j1]+grid[i][j2];
                                if(j1+dj1>=0 && j1+dj1<n && j2+dj2>=0 && j2+dj2<n)
                                value+=dp[j1+dj1][j2+dj2];
                                else
                                value+=(int)-1e9;
                                max=Math.max(max,value);
                            }
                        }
                        temp[j1][j2]=max;
                }
            }
            dp=temp;
        }
        return dp[0][n-1];
    }
}
