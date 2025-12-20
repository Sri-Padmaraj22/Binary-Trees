package DP;
import java.util.*;
public class FrogJump {
  int minCost(int[] height) {
        // code here
        int n=height.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return minCost3(height,n);
    }
    //Memoization
    int minCost(int[] height,int dp[],int n)
    {
        if(n==0)
        return 0;
        if(dp[n]!=-1) return dp[n];
        int left=minCost(height,dp,n-1)+Math.abs(height[n]-height[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1)
        right=minCost(height,dp,n-2)+Math.abs(height[n]-height[n-2]);
        
        dp[n]=Math.min(left,right);
        return dp[n];
    }
    
    int minCost2(int height[],int dp[],int n)
    {
        dp[0]=0;
        
        for(int i=1;i<n;i++)
        {
            int oneStep=dp[i-1]+Math.abs(height[i]-height[i-1]);
            int twoStep=Integer.MAX_VALUE;
            if(i>1)
            twoStep=dp[i-2]+Math.abs(height[i]-height[i-2]);
            
            dp[i]=Math.min(oneStep,twoStep);
        }
        return dp[n-1];
    }
    
    //Space optimized
    int minCost3(int height[],int n)
    {
        int prev=0,prev2=0;
        
        for(int i=1;i<n;i++)
        {
            int oneStep=prev+Math.abs(height[i]-height[i-1]);
            int twoStep=Integer.MAX_VALUE;
            if(i>1)
            twoStep=prev2+Math.abs(height[i]-height[i-2]);
            int curr=Math.min(oneStep,twoStep);
            prev2=prev;
            prev=curr;
            
        }
        return prev;
    }
}
