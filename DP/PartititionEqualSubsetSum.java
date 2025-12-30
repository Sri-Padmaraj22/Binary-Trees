package DP;

import java.util.Arrays;

public class PartititionEqualSubsetSum {
  public boolean canPartition(int[] nums) {
        int target=0;
        for(int a:nums)
        target+=a;
        if(target%2!=0) return false;
        boolean dp[][]=new boolean[nums.length][target+1];
        for(int i=0;i<nums.length-1;i++)
        Arrays.fill(dp[i],false);
        
        //return helper1(nums.length-1,target/2,nums,dp);

        return helper2(target/2,nums);
        //return helper3(target/2,nums);
    }
    //Memoization
    public boolean helper1(int ind,int target,int nums[],boolean[][] dp)
    {
        if (target==0)
        return true;
        if(ind==0)
        return nums[0]==target;
        if(dp[ind][target]!=false) return dp[ind][target];

        boolean notTake=helper1(ind-1,target,nums,dp);
        boolean take=false;
        if(target>=nums[ind])
        take=helper1(ind-1,target-nums[ind],nums,dp);
        return dp[ind][target]=take||notTake;
    }
    //tabulation
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
