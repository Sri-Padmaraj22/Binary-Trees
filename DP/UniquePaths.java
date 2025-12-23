package DP;
public class UniquePaths {
   public int uniquePaths(int m, int n) {
        //int dp[][]=new int[m][n];
        /*for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            dp[i][j]=-1;
        }
        return uniquePaths(m-1,n-1,dp);*/
        int dp[]=new int[n];
        return uniquePaths3(m,n,dp);
    }

    //Memoization
    public int uniquePaths(int i,int j,int dp[][])
    {
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        int up=uniquePaths(i-1,j,dp);
        int left=uniquePaths(i,j-1,dp);
        return dp[i][j]=left+up;
    }

    //Tabulation
    public int uniquePaths2(int m,int n,int dp[][])
    {
        dp[0][0]=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0) dp[0][0]=1;
                
                else
                {
                int down=0,right=0;
                if(i-1>=0)
                down=dp[i-1][j];
                if(j-1>=0)
                right=dp[i][j-1];

                dp[i][j]=down+right;
                }   
                

            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePaths3(int m,int n,int dp[])
    {
        for(int i=0;i<m;i++)
        {
            int temp[]=new int[n];
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0) temp[j]=1;
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
