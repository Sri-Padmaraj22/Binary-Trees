package DP;

import java.util.Arrays;

public class StockIV {
  public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        // int dp[][][]=new int[n][2][k+1];
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<2;j++)
        //     {
        //         for(int kk=0;kk<k+1;kk++)
        //         {
        //             dp[i][j][kk]=-1;
        //         }
        //     }
        // }
        int dp[][]=new int[n][2*k];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        //return memo(0,1,prices,k,dp);
        //return tabulation(prices,k);
        //return spaceOptimized(prices,k);
        return helper(0,0,k,prices,dp);
    }

     public int memo(int ind,int buy,int prices[],int count,int dp[][][])
    {
        if(ind==prices.length|| count==0)
        return 0;
        //Buy-->1 Can buy
        //Buy-->2 Cannot buy
        if(dp[ind][buy][count]!=-1) return dp[ind][buy][count];
        if(buy==1)
        {
            int take=-prices[ind]+memo(ind+1,0,prices,count,dp);
            int notTake=0+memo(ind+1,1,prices,count,dp);
            return dp[ind][buy][count]=Math.max(take,notTake);
        }
        else
        {
            int take=prices[ind]+memo(ind+1,1,prices,count-1,dp);
            int notTake=0+memo(ind+1,0,prices,count,dp);
            return dp[ind][buy][count]=Math.max(take,notTake);
        }
    }

    public int tabulation(int prices[],int k)
    {
        int n=prices.length;
        int dp[][][]=new int[n+1][2][k+1];
        // for(int j=0;j<2;j++)
        // {
        //     for(int k=0;k<3;k++)
        //     dp[n-1][j][k]=0;
        // }
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<2;j++)
        //     {
        //         dp[i][j][0]=0;
        //     }
        // }
        //ind -->n-1 to 0
        //buy --> 0 to 1
        //count --> 1 to 2 (since 0 is already 0)
        for(int ind=n-1;ind>=0;ind--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                for(int count=1;count<=k;count++)
                {
                    if(buy==1)
                        {
                            int take=-prices[ind]+dp[ind+1][0][count];
                            int notTake=0+dp[ind+1][1][count];
                            dp[ind][buy][count]=Math.max(take,notTake);
                        }
                    else
                        {
                            int take=prices[ind]+dp[ind+1][1][count-1];
                            int notTake=0+dp[ind+1][0][count];
                            dp[ind][buy][count]=Math.max(take,notTake);
                        }
                }
            }
        }
        return dp[0][1][k];
    }

    public int spaceOptimized(int prices[],int k)
    {
        int n=prices.length;
        int dp[][]=new int[2][k+1];
        // for(int j=0;j<2;j++)
        // {
        //     for(int k=0;k<3;k++)
        //     dp[j][k]=0;
        // }
        // for(int j=0;j<2;j++)
        // {
        //         dp[j][0]=0;
        // }
        //ind -->n-1 to 0
        //buy --> 0 to 1
        //count --> 1 to 2 (since 0 is already 0)
        for(int ind=n-1;ind>=0;ind--)
        {
            int temp[][]=new int[2][3];
            for(int buy=0;buy<=1;buy++)
            {
                for(int count=1;count<=k;count++)
                {
                    if(buy==1)
                        {
                            int take=-prices[ind]+dp[0][count];
                            int notTake=0+dp[1][count];
                            temp[buy][count]=Math.max(take,notTake);
                        }
                    else
                        {
                            int take=prices[ind]+dp[1][count-1];
                            int notTake=0+dp[0][count];
                            temp[buy][count]=Math.max(take,notTake);
                        }
                }
            }
            dp=temp;
        }
        return dp[1][k];
    }


    public int helper(int ind,int transaction,int k,int prices[],int dp[][])
    {
        if(transaction==2*k || ind==prices.length)
        return 0;
        if(dp[ind][transaction]!=-1) return dp[ind][transaction];
        if(transaction%2==0) //buy
        {
            int take=-prices[ind]+helper(ind+1,transaction+1,k,prices,dp);
            int notTake=0+helper(ind+1,transaction,k,prices,dp);
            return dp[ind][transaction]=Math.max(take,notTake);
        }
        else //sell
        {
            int take=prices[ind]+helper(ind+1,transaction+1,k,prices,dp);
            int notTake=0+helper(ind+1,transaction,k,prices,dp);
            return dp[ind][transaction]=Math.max(take,notTake);
        }

    }
}
