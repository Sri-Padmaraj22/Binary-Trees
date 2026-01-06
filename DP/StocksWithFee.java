package DP;

import java.util.Arrays;

public class StocksWithFee {
  public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        //return memo(0,1,prices,fee,dp);
        return space(prices,fee);
    }

    public int memo(int ind,int buy,int prices[],int fee,int dp[][])
    {
        if(ind==prices.length) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit=0;
        if(buy==1)
        {
            int take=-prices[ind]+memo(ind+1,0,prices,fee,dp);
            int notTake=memo(ind+1,1,prices,fee,dp);
            profit=Math.max(take,notTake);
        }
        else
        {
            int take=prices[ind]-fee+memo(ind+1,1,prices,fee,dp);
            int notTake=memo(ind+1,0,prices,fee,dp);
            profit=Math.max(take,notTake);
        }
        return dp[ind][buy]=profit;
    }

    public int tabulation(int prices[],int fee)
    {
        int n=prices.length;
        int dp[][]=new int[n+1][2];

        for(int ind=n-1;ind>=0;ind--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                int profit=0;
                if(buy==1)
                {
                    int take=-prices[ind]+dp[ind+1][0];
                    int notTake=dp[ind+1][1];
                    profit=Math.max(take,notTake);
                }
                else
                {
                    int take=prices[ind]-fee+dp[ind+1][1];
                    int notTake=dp[ind+1][0];
                    profit=Math.max(take,notTake);
                }
                dp[ind][buy]=profit;
            }
        }
        return dp[0][1];
    }

    public int space(int prices[],int fee)
    {
        int n=prices.length;
        int dp[]=new int[2];
        int temp[]=new int[2];
        for(int ind=n-1;ind>=0;ind--)
        {
            int take=-prices[ind]+dp[0];
            int notTake=dp[1];
            temp[1]=Math.max(take,notTake);
                
            int take1=prices[ind]-fee+dp[1];
            int notTake1=dp[0];
            temp[0]=Math.max(take1,notTake1);
            dp=temp.clone();
        }
        return temp[1];
    }
}
