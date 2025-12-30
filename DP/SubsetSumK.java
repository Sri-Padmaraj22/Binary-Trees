package DP;
import java.util.*;
public class SubsetSumK
{
  public boolean isSubsetSum(int[] arr, int target) {
    int n=arr.length;
    boolean dp[][]=new boolean[n][target+1];
    for(int i=0;i<n;i++)
      Arrays.fill(dp[i],false);
    return isSubsetSum(n-1,target,arr,dp);
    }
    //Memoization
    public static boolean isSubsetSum(int ind,int target,int arr[],boolean dp[][])
    {
      if(ind==0) return arr[0]==target;
      if(target==0) return true;

      if(dp[ind][target]!=false) return dp[ind][target];

      boolean notTake=isSubsetSum(ind-1, target, arr, dp);
      boolean take=false;
      if(target>=arr[ind])
        take=isSubsetSum(ind, target-arr[ind], arr, dp);

      return dp[ind][target]=take||notTake;
    }

    //Tabulation

    public static boolean helper2(int target,int arr[])
    {
      int n=arr.length;
      boolean dp[][]=new boolean[arr.length][target+1];
      if(arr[0]<=target)
      dp[0][arr[0]]=true;
      for(int i=0;i<n;i++)
        dp[i][0]=true;

      for(int i=1;i<n;i++)
      {
        for(int j=1;j<=target;j++)
        {
          boolean notTake=dp[i-1][j];
          boolean take=false;
          if(j>=arr[i])
             take=dp[i-1][j-arr[i]];
          dp[i][j]=take||notTake;
        }
      }
      return dp[n-1][target];
    }

    //Space Optimization
    public static boolean helper3(int target,int arr[])
    {
      int n=arr.length;
      boolean dp[]=new boolean[target+1];
      dp[0]=true;
      if(arr[0]<=target)
      dp[arr[0]]=true;
      for(int i=1;i<n;i++)
      {
        boolean temp[]=new boolean[target+1];
        temp[0]=true;
        for(int j=1;j<=target;j++)
        {
          boolean notTake=dp[j];
          boolean take=false;
          if(j>=arr[i])
             take=dp[j-arr[i]];
           temp[j]=take||notTake;
        }
        dp=temp;
      }
      return dp[target];
    }
}