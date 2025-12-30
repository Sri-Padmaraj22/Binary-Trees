package DP;

import java.util.Arrays;

public class CountSubsetSum {
  
  public static int findWays(int arr[],int sum)
  {
    int n=arr.length;

    int dp[][]=new int[n][sum+1];
    for(int i=0;i<n;i++)
      Arrays.fill(dp[i],-1);
    return helper(n-1,sum,arr,dp);
  }

  //Memoization
  public static int helper(int ind,int sum,int arr[],int dp[][])
  {
    if(ind==0)
    {
      //2 because we can either take that 0 or leave that 0 wont affect the sum. So 2 possible options
      if(sum==0 && arr[0]==0) return 2;
      if(sum==0) return 1;
      if(arr[0]==sum) return 1;
    }
    if(dp[ind][sum]!=-1) return dp[ind][sum];
    int notPick=helper(ind-1,sum,arr,dp);
    int pick=0;
    if(arr[ind]<=sum)
      pick=helper(ind-1,sum-arr[ind],arr,dp);

    return dp[ind][sum]=pick+notPick;
  }
  //Tabulation
  public static int helper(int sum,int arr[])
  {
    int n=arr.length;
    int dp[][]=new int[arr.length][sum+1];
    if(arr[0]==0) dp[0][0]=2;
    else dp[0][0]=1;
    if(arr[0]!=0 && arr[0]<=sum)
      dp[0][arr[0]]=1;

    for(int i=1;i<n;i++)
    {
      for(int s=0;s<=sum;s++)
      {
        int notPick=dp[i-1][s];
        int pick=0;
        if(arr[i]<=s)
          pick=dp[i-1][s-arr[i]];
        dp[i][s]=pick+notPick;
      }
    }
    return dp[n-1][sum];
  }
  //Space Optimization
  public static int helper2(int sum,int arr[])
  {
    int n=arr.length;
    int dp[]=new int[sum+1];
    if(arr[0]==0) dp[0]=2;
    else dp[0]=1;
    if(arr[0]!=0 && arr[0]<=sum)
      dp[arr[0]]=1;
    for(int i=1;i<n;i++)
    {
      int temp[]=new int[sum+1];
      for(int s=0;s<=sum;s++)
      {
        int notPick=dp[s];
        int pick=0;
        if(arr[i]<=s)
          pick=dp[s-arr[i]];
        temp[s]=pick+notPick;
      }
      dp=temp;
    }
    return dp[sum];
  }

}
