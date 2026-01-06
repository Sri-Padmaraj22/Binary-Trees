package DP;
import java.util.*;
public class BuyAndSellStocksII{
  public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        //return memo(0,1,prices,dp); 
        return tabulation(prices);  
    }

    public int memo(int ind,int buy,int prices[],int dp[][])
    {
        if(ind==prices.length)
        return 0;

        if(dp[ind][buy]!=-1) return dp[ind][buy];
        // Buy=1 --> You can buy that day
        // Buy=0 --> You cannot buy that day
        if(buy==1)
        {
            //You can buy that stock
            int take=-prices[ind]+memo(ind+1,0,prices,dp);

            //You can skip that stock
            int notTake=0+memo(ind+1,1,prices,dp);
            return dp[ind][buy]=Math.max(take,notTake);
        }
        else
        {
            //You can sell that stock
            int take=prices[ind]+memo(ind+1,1,prices,dp);

            //You dont sell that stock
            int notTake=0+memo(ind+1,0,prices,dp);
            return dp[ind][buy]= Math.max(take,notTake);
        }
    }
    public int tabulation(int prices[])
    {
        int n=prices.length;
        int dp[][]=new int[n+1][2];
        dp[n][0]=0;
        dp[n][1]=0;
        
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<=1;j++)
            {
                if(j==1)
                    {
                        //You can buy that stock
                        int take=-prices[i]+dp[i+1][0];

                        //You can skip that stock
                        int notTake=0+dp[i+1][1];
                        dp[i][j]=Math.max(take,notTake);
                    }
                else
                    {
                        //You can sell that stock
                        int take=prices[i]+dp[i+1][1];

                        //You dont sell that stock
                        int notTake=0+dp[i+1][0];
                        dp[i][j]= Math.max(take,notTake);
                    }
            }

        }
        return dp[0][1];

    }
    public int spaceOptimized(int prices[])
    {
        int n=prices.length;
        int dp[]=new int[2];
        for(int i=n-1;i>=0;i--)
        {
            int temp[]=new int[2];
            for(int j=0;j<=1;j++)
            {
                if(j==1)
                    {
                        //You can buy that stock
                        int take=-prices[i]+dp[0];

                        //You can skip that stock
                        int notTake=0+dp[1];
                        temp[j]=Math.max(take,notTake);
                    }
                else
                    {
                        //You can sell that stock
                        int take=prices[i]+dp[1];

                        //You dont sell that stock
                        int notTake=0+dp[0];
                        temp[j]= Math.max(take,notTake);
                    }
            }
            dp=temp;
        }

        return dp[1];

    }
}