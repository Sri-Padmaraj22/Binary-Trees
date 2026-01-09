package DP;


import java.util.Arrays;


public class LongestBitonicSubsequence {
  public int bitonicCount(int[] nums) {
        int n=nums.length;
        int dp1[]=new int[n];
        int dp2[]=new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        for(int i=0;i<n;i++)
        {

            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0 && dp1[i]<(dp1[j]+1))
                {
                    dp1[i]=dp1[j]+1;
                }
            }
        }

        for(int i=n-1;i>=0;i--)
        {

            for(int j=n-1;j>i;j--)
            {
                if(nums[i]%nums[j]==0 && dp2[i]<(dp2[j]+1))
                {
                    dp2[i]=dp2[j]+1;
                }
            }
        }
        int bitonicLength=0;
        for(int i=0;i<n;i++)
        {
          int len=dp1[i]+dp2[i]-1;
          bitonicLength=Math.max(len,bitonicLength);
        }
        return bitonicLength;
    }
}
