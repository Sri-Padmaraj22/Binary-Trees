public class Koko {
     public int minEatingSpeed(int[] piles, long h) {
        int low=0;
        int high=max(piles);
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            long k=helper(piles,mid);
            if(k<=h)
            {   ans=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return ans;

    }
    public long helper(int[] a,int k)
    {
        long  sum=0;
        for(int i=0;i<a.length;i++)
        {
            sum+=Math.ceil((double)a[i]/(double)k);
        }
        return sum;
    }
    public int max(int a[])
    {
        int max=a[0];
        for(int i=1;i<a.length;i++)
        {
            max=Math.max(max,a[i]);
        }
        return max;
    }
}
