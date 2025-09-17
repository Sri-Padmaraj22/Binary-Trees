public class MinDayBouquet {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<(m*k))
        return -1;
        int low=0,high=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++)
        {
            max=Math.max(max,bloomDay[i]);
            min=Math.min(min,bloomDay[i]);
        }
        low=min;
        high=max;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(helper(bloomDay,m,k,mid))
            {
                ans=mid;
                high=mid-1;
            }
            else
            low=mid+1;

        }
        return ans;
    }

    public boolean helper(int bloomDay[],int m,int k,int mid)
    {
        int count=0,ans=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i]<=mid)
            count++;
            else
            {
                ans+=count/k;
                count=0;
            }

        }
        ans+=count/k;
        return ans>=m;
    }
}
