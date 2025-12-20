package DP;

import java.util.Arrays;

public class FrogJumpK {
  public int frogJump(int[] heights, int k) {
        int n=heights.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return frogJump2(heights,dp,k,n);
    }
    //Memoization
    public int frogJump(int[] heights,int dp[],int k,int n)
    {
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int minSteps=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++)
        {
            if(n-i>=0)
            {
                int step=frogJump(heights,dp,k,n-i)+Math.abs(heights[n]-heights[n-i]);
                minSteps=Math.min(step,minSteps);
            }
        }
        return dp[n-1]=minSteps;
    }
    //Tabulation
    public int frogJump2(int [] heights,int dp[],int k,int n)
    {
        dp[0]=0;

        for(int i=1;i<n;i++)
        {
            int minSteps=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++)
            {
                if(i-j>=0)
                {
                    int jump=dp[i-j]+Math.abs(heights[i]-heights[i-j]);
                    minSteps=Math.min(minSteps,jump);
                }

            }
            dp[i]=minSteps;
        }
        return dp[n-1];
    }
}
