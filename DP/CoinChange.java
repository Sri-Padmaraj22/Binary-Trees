package DP;

import java.util.Arrays;

public class CoinChange {
  public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);

        /*int ans=f(n-1,amount,coins,dp);
        if(ans>=(int)1e9)
        return -1;
        else
        return ans;*/
        return f2(coins,amount);

    }
    //Memoization
    public int f(int ind,int amount, int coins[],int dp[][])
    {
        if(ind==0)
        {
            if(amount%coins[0]==0) return amount/coins[0];
            else return (int)1e9;
        }

        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int notTake=0+f(ind-1,amount,coins,dp);
        int take=(int)1e9;
        if(coins[ind]<=amount)
        take=1+f(ind,amount-coins[ind],coins,dp);
        return dp[ind][amount]=Math.min(take,notTake);
    }
    //Tabulation
    public int f(int coins[],int amount)
    {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
            dp[0][i]=i/coins[0];
            else
            dp[0][i]=(int)1e9;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                int notTake=dp[i-1][j];
                int take=(int)1e9;
                if(coins[i]<=j)
                take=1+dp[i][j-coins[i]];

                dp[i][j]=Math.min(notTake,take);
            }
        }
        int ans=dp[n-1][amount];
        if(ans>=(int)1e9)
        return -1;
        else
        return ans;
    }
    //Space Optimization
    public int f2(int coins[],int amount)
    {
        int n=coins.length;
        int dp[]=new int[amount+1];
        for(int i=0;i<=amount;i++)
        {
            if(i%coins[0]==0)
            dp[i]=i/coins[0];
            else
            dp[i]=(int)1e9;
        }
        for(int i=1;i<n;i++)
        {
            int temp[]=new int[amount+1];
            for(int j=0;j<=amount;j++)
            {
                int notTake=dp[j];
                int take=(int)1e9;
                if(coins[i]<=j)
                take=1+temp[j-coins[i]];

                temp[j]=Math.min(notTake,take);
            }
            dp=temp;
        }
        int ans=dp[amount];
        if(ans>=(int)1e9)
        return -1;
        else
        return ans;
    }
}
