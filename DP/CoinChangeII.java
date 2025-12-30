package DP;
import java.util.*;
public class CoinChangeII {
  public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        int ans=helper2(amount,coins);
        return ans;
    }
    //Memoization
    public int f(int ind,int target, int arr[],int dp[][])
    {
        if(ind==0)
        {
            if(target%arr[0]==0) return 1;
            return 0;

        }
        if(dp[ind][target]!=-1) return dp[ind][target];

        int notPick=f(ind-1,target,arr,dp);
        int Pick=0;
        if(arr[ind]<=target)
        Pick=f(ind,target-arr[ind],arr,dp);
        return dp[ind][target]=Pick+notPick;
    }

    //Tabulation
    public int helper(int amount,int coins[])
    {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
            dp[0][i]=1;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                int notPick=dp[i-1][j];
                int Pick=0;
                if(coins[i]<=j)
                Pick=dp[i][j-coins[i]];
                dp[i][j]=Pick+notPick;
            }
        }
        return dp[n-1][amount];
    }
    //Space Optimization
    public int helper2(int amount,int coins[])
    {
        int n=coins.length;
        int dp[]=new int[amount+1];
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
            dp[i]=1;
        }
        for(int i=1;i<n;i++)
        {
            int temp[]=new int[amount+1];
            for(int j=0;j<=amount;j++)
            {
                int notPick=dp[j];
                int Pick=0;
                if(coins[i]<=j)
                Pick=temp[j-coins[i]];
                temp[j]=Pick+notPick;
            }
            dp=temp;
        }
        return dp[amount];
    }
}
