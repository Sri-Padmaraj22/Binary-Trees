package DP;

public class UniquePaths2 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
     int m=obstacleGrid.length;
     int n=obstacleGrid[0].length;
     //int dp[][]=new int[m][n];
     /*for(int i=0;i<m;i++)
     {
        for(int j=0;j<n;j++)
        dp[i][j]=-1;
     }*/
     return helper2(m,n,obstacleGrid);   
    }

    public int helper(int i,int j,int obstacleGrid[][],int dp[][])
    {
        if(i>=0 && j>=0 && obstacleGrid[i][j]==1) return 0;
        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];

        int left=helper(i,j-1,obstacleGrid,dp);
        int up=helper(i-1,j,obstacleGrid,dp);
        return dp[i][j]=left+up;
    }
    //Tabulation
    public int helper2(int m,int n,int obstacleGrid[][],int dp[][])
    {
        dp[0][0]=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else if(i==0 && j==0) dp[i][j]=1;
                else
                {
                    
                    int down=0,right=0;
                    
                        if(i>0)
                        down=dp[i-1][j];
                        if(j>0)
                        right=dp[i][j-1];
                    
                    dp[i][j]=down+right;
                }
            }
        }
        return dp[m-1][n-1];
    }
    //Space Optimization
    public int helper2(int m,int n,int obstacleGrid[][])
    {
        int dp[]=new int[n];
        for(int i=0;i<m;i++)
        {
            int temp[]=new int[n];
            for(int j=0;j<n;j++)
            {
                if(obstacleGrid[i][j]==1) temp[j]=0;
                else if(i==0 && j==0) temp[j]=1;
                else
                {
                    int down=0,right=0;
                    if(i>0)
                    down=dp[j];
                    if(j>0)
                    right=temp[j-1];
                    temp[j]=down+right;
                }
            }

            dp=temp;
        }
        return dp[n-1];
    }
}
