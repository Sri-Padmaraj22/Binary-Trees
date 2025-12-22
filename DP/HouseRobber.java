package DP;
//import java.util.*;
public class HouseRobber {
  public int rob(int[] nums) {
        //int dp[]=new int[nums.length];
        //Memoization
        /*{
            Arrays.fill(dp,-1);
            return rob(nums,nums.length-1,dp);
        }*/

        //Tabulation
        /*{
            Arrays.fill(dp,0);
            return rob(nums,dp);
        }*/

        //Space Optimization
        {
            return rob2(nums);
        }

    }
    //Memoization
    public int rob(int[] nums,int ind,int[] dp)
    {
        if(ind==0) return nums[0];
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int pick= nums[ind]+ rob(nums,ind-2,dp);
        int notpick=0 + rob(nums,ind-1,dp);
        dp[ind]=Math.max(pick, notpick);
        return dp[ind];
    }

    //Tabulation
    public int rob(int[] nums,int dp[])
    {
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int take=nums[i];
            if(i>1) take+=dp[i-2];
            int notTake=0+dp[i-1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[nums.length-1];
    }

    //Space Optimization
    public int rob2(int[] nums)
    {
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<nums.length;i++)
        {
            int take=nums[i];
            if(i>1)
            take+=prev2;

            int notTake=0+prev;

            int currI=Math.max(take,notTake);
            prev2=prev;
            prev=currI;

        }
        return prev;
    }
}
