package DP;
import java.util.*;
public class BurstBalloons{
  public int maxCoins(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n+2];
        arr[0]=1;
        for(int i=1;i<=n;i++)
        {
            arr[i]=nums[i-1];
        }
        arr[arr.length-1]=1;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        //return memo(1,nums.length,arr,dp);
        return tabulation(nums);
    }
    public int memo(int i,int j, int arr[],int dp[][])
    {
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxi=(int)-1e9;
        for(int ind=i;ind<=j;ind++)
        {
            int cost=(arr[i-1]*arr[ind]*arr[j+1])+memo(i,ind-1,arr,dp)+memo(ind+1,j,arr,dp);
            maxi=Math.max(cost,maxi);
        }
        return dp[i][j]=maxi;
    }
    public int tabulation(int[] nums)
    {
        int n=nums.length;
        int arr[]=new int[n+2];
        arr[0]=1;
        for(int i=1;i<=n;i++)
        {
            arr[i]=nums[i-1];
        }
        arr[arr.length-1]=1;
        int dp[][]=new int[n+2][n+2];

        for(int i=n;i>=1;i--)
        {
            for(int j=1;j<=n;j++)
            {
                if(i>j) continue;
                int maxi=(int)-1e9;
                for(int ind=i;ind<=j;ind++)
                {
                    int cost=(arr[i-1]*arr[ind]*arr[j+1])+dp[i][ind-1]+dp[ind+1][j];
                    maxi=Math.max(cost,maxi);
                }
                dp[i][j]=maxi;
            }
        }
        return dp[1][n];
    }
}