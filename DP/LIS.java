package DP;
import java.util.*;
public class LIS{
  public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        return memo(0,0,nums,dp);
    }

    public int memo(int ind,int prev,int nums[],int dp[][])
    {
        if(ind==nums.length) return 0;

        if(dp[ind][prev]!=-1) return dp[ind][prev];
        //Not-take
        int len=0+memo(ind+1,prev,nums,dp);
        //Take
        if(prev==0 || nums[ind]>nums[prev-1]) 
        len=Math.max(len,1+memo(ind+1,ind+1,nums,dp));
        return dp[ind][prev]=len;
    }

    public int tabulation(int nums[])
    {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];

        for(int ind=n-1;ind>=0;ind--)
        {
            for(int prev=ind-1;prev>=-1;prev--)
            {
                //Not-take
                int len=dp[ind+1][prev+1];
                //Take
                if(prev==-1 || nums[ind]>nums[prev]) 
                len=Math.max(len,1+dp[ind+1][ind+1]);
                dp[ind][prev+1]=len;
            }
        }
        return dp[0][-1+1];
    }

    public int tabulation2(int nums[])
    {
        int dp[]=new int[nums.length];
        int n=nums.length;
        int maxi=1;
        Arrays.fill(dp,1);
        for(int ind=0;ind<n;ind++)
        {
            for(int prev=0;prev<ind;prev++)
            {
                if(nums[prev]<nums[ind])
                {
                    dp[ind]=Math.max(dp[ind],1+dp[prev]);
                }
            }
            maxi=Math.max(maxi,dp[ind]);
        }
        return maxi;
    }

    public int print(int nums[])
    {
        int n=nums.length;
        int dp[]=new int[nums.length];
        int hash[]=new int[nums.length];
        for(int i=0;i<n;i++)
        hash[i]=i;
        int maxi=1;
        int last_index=0;
        Arrays.fill(dp,1);
        for(int ind=0;ind<n;ind++)
        {
            for(int prev=0;prev<ind;prev++)
            {
                if(nums[prev]<nums[ind])
                {
                    dp[ind]=Math.max(dp[ind],1+dp[prev]);
                    hash[ind]=prev;
                }
            }
           if(dp[ind]>maxi)
           {
                maxi=dp[ind];
                last_index=ind;
           }
        }
        int ans[]=new int[maxi];
        ans[0]=nums[last_index];
        int j=1;
        while(hash[last_index]!=last_index)
        {
            last_index=hash[last_index];
            ans[j++]=nums[last_index];
        }
        for(int i=maxi-1;i>=0;i--)
        {
            System.out.print(ans[i]+" ");
        }
        return maxi;
    }
}