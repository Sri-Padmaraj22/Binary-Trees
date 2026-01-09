package DP;
import java.util.*;
public class LargestDivisibleSubset{
   public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        List<Integer> arr=new ArrayList<>();
        int dp[]=new int[n];
        int hash[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        int maxi=1;
        int lastIndex=0;
        for(int i=0;i<n;i++)
        {
            hash[i]=i;
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0 && dp[i]<(dp[j]+1))
                {
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            if(dp[i]>maxi)
            {
                maxi=dp[i];
                lastIndex=i;
            }
        }
        arr.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex)
        {
            lastIndex=hash[lastIndex];
            arr.add(nums[lastIndex]);
        }
        return arr;

    }
}