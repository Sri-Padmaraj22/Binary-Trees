package DP;

import java.util.Arrays;

public class MCM {
  
  public int Mcm(int nums[])
  {
    int n=nums.length;
    int dp[][]=new int[n][n];
    for(int i=0;i<n;i++)
    Arrays.fill(dp[i],-1);
    return f(1,n-1,nums,dp);
  }

  public int f(int i,int j ,int nums[],int dp[][])
  {
    if(i==j) return 0;
    if(dp[i][j]!=-1) return dp[i][j];
    int min=(int)1e9;
    for(int k=i;k<j;k++)
    {
      int steps=(nums[i-1]*nums[k]*nums[j])+f(i,k,nums,dp)+f(k+1,j,nums,dp);
      min=Math.min(min,steps);
    }
    return dp[i][j]=min;
  }
  public int tabulation(int nums[])
  {
    int n=nums.length;
    int dp[][]=new int[n][n];
    for(int i=1;i<n;i++)
      dp[i][i]=0;
    for(int i=n-1;i>=1;i--)
    {
      for(int j=i+1;j<n;j++)
      {
        int mini=(int)1e9;
        for(int k=i;k<j;k++)
        {
          int steps=(nums[i-1]*nums[k]*nums[j])+dp[i][k]+dp[k+1][j];
          mini=Math.min(mini,steps);
        }
        dp[i][j]=mini;
      }
    }
    return dp[1][n-1];
  }
}
