package Arrays;
public class MaxProductSub
{
    public int maxProduct(int[] nums) {
        int N=nums.length;
        int pre=1,suff=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++)
        {
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre=pre*nums[i];
            suff=suff*nums[N-i-1];
            max=Math.max(max,Math.max(pre,suff));


        }
        return max;
    }
}