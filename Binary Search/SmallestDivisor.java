public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(max,nums[i]);
            
        }
        int high=max;
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(helper(nums,mid)<=threshold)
            {
                ans=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return ans;
    }
    public int helper(int nums[],int mid)
    {
        int sum=0;
        for(int a:nums)
        {
            sum+=Math.ceil((double)a/(double)mid);
        }
        return sum;
    }
}
