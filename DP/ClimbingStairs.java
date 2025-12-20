package DP;
import java.util.*;
public class ClimbingStairs{
  public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return climbStairs3(n);
    }
    //Memoization
    public int climbStairs(int n,int dp[])
    {
        if(n==0|| n==1) return 1;
        if(dp[n]==-1)
        {
            dp[n]=climbStairs(n-1,dp)+climbStairs(n-2,dp);
        }
        return dp[n];
    }

    //Tabulation
    public int climbStairs2(int n,int dp[])
    {
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++)
        dp[i]=dp[i-1]+dp[i-2];

        return dp[n];
    }

    //Space optimized
    public int climbStairs3(int n)
    {
     if(n==0 || n==1) return 1;
     int prev=1,curr=1;

     for(int i=2;i<=n;i++)
     {
        int temp=curr;
        curr=prev+curr;
        prev=temp;
     }   
     return curr;
    }
}