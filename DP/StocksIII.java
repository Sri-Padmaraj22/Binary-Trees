package DP;
public class StocksIII {
   public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n][2][3];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=0;k<3;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        //return memo(0,1,prices,2,dp); 
        //return tabulation(prices);
        return spaceOptimized(prices);  
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

    public int tabulation(int prices[])
    {
        int n=prices.length;
        int dp[][][]=new int[n+1][2][3];
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
                for(int count=1;count<=2;count++)
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
        return dp[0][1][2];
    }

    public int spaceOptimized(int prices[])
    {
        int n=prices.length;
        int dp[][]=new int[2][3];
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
                for(int count=1;count<=2;count++)
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
        return dp[1][2];
    }
}
