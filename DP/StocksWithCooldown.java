package DP;
import java.util.*;
public class StocksWithCooldown {
  public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        //return memo(0,1,prices,dp);
        return space(prices);
    }

    public int memo(int ind,int buy,int prices[],int dp[][])
    {
        if(ind>=prices.length)
        return 0;

        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit=0;
        if(buy==1)
        {
            int take= -prices[ind]+memo(ind+1,0,prices,dp);
            int notTake=0+memo(ind+1,1,prices,dp);
            profit=Math.max(take,notTake);
        }
        else
        {
            int take= prices[ind]+memo(ind+2,1,prices,dp);
            int notTake=0+memo(ind+1,0,prices,dp);
            profit=Math.max(take,notTake);
        }
        return dp[ind][buy]=profit;
    }

    
    
    public int space(int prices[])
    {
        int n=prices.length;
        int dp1[]=new int[2];
        int temp[]=new int[2];
        int dp2[]=new int[2];
        for(int ind=n-1;ind>=0;ind--)
        {
            //No need of that internal buy loop.
            //We will run for both 1 and 0 cases so, without loop we are calculating.
            
            int take=-prices[ind]+dp1[0];
            int notTake=dp1[1];
            temp[1]=Math.max(take,notTake);


            int take1= prices[ind];
            if(ind+2<n) take1+=dp2[1];
            int notTake1=dp1[0];
            temp[0]=Math.max(take1,notTake1);

            dp2=dp1.clone();
            dp1=temp.clone();
        }
        return temp[1];
    }
}
