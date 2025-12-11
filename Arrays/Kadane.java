package Arrays;

public class Kadane {
   public int maxSubArray(int[] arr) {
        int n=arr.length;
        if(n==1)
        return arr[0];
        int sum=0,maxSum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            maxSum=Math.max(sum,maxSum);
            if(sum<0)
            sum=0;
            
        }
        return maxSum;
    }
}
