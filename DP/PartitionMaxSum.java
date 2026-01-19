package DP;

import java.util.Arrays;

public class PartitionMaxSum {
  public int maxSumAfterPartitioning(int[] arr, int k) {
     int n=arr.length;
     int dp[]=new int[n];
     Arrays.fill(dp,-1);
     //return memo(0,n,k,arr,dp); 
     return tabulation(arr, k);
    }
    public int memo(int i,int n,int k,int arr[],int dp[])
    {
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int maxSum=(int)-1e9;
        int maxi=(int)-1e9;
        int len=0;
        for(int j=i;j<Math.min(n,i+k);j++)
        {
            len++;
            maxi=Math.max(maxi,arr[j]);
            int sum=(len*maxi)+memo(j+1,n,k,arr,dp);
            maxSum=Math.max(sum,maxSum);
        }
        return dp[i]=maxSum;
    }
    public int tabulation(int arr[],int k)
    {
        int n=arr.length;
        int dp[]=new int[n+1];
        for(int i=n-1;i>=0;i--)
        {
            int maxSum=(int)-1e9;
            int maxi=(int)-1e9;
            int len=0;
            for(int j=i;j<Math.min(n,i+k);j++)
            {
                len++;
                maxi=Math.max(maxi,arr[j]);
                int sum=(len*maxi)+dp[j+1];
                maxSum=Math.max(sum,maxSum);
            }
            dp[i]=maxSum;
        }
        return dp[0];
    }
}
