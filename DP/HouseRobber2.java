package DP;

public class HouseRobber2 {
  public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
        return nums[0];
        int prev1=nums[0];
        int prev2=0;
        int ans1=0,ans2=0;
        //Leave out last element
        for(int i=1;i<n-1;i++)
        {
            int take=nums[i];
            if(i>1) take+=prev2;
            int notTake=prev1;
            int currI=Math.max(take,notTake);
            prev2=prev1;
            prev1=currI;
        }
        ans1=prev1;

        //Leave out first element
        prev1=nums[1];
        prev2=0;
        for(int i=2;i<n;i++)
        {
            int take=nums[i];
            if(i>1) take+=prev2;
            int notTake=prev1;
            int currI=Math.max(take,notTake);
            prev2=prev1;
            prev1=currI;
        }
        ans2=prev1;

        return Math.max(ans1,ans2);
    }
}
