public class LeastCapacity {
    public int shipWithinDays(int[] weights, int days) {
        int max=0,sum=0;
        for(int i=0;i<weights.length;i++)
        {
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        int low=max;
        int high=sum;
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(helper(weights,mid)>days)
            {
             low=mid+1;   
            }
            else if(helper(weights,mid)<=days)
            {
                ans=mid;
                high=mid-1;
            }

        }
        return ans;
    }
    public int helper(int weights[],int cap)
    {
        int day=1,load=0;

        for(int i=0;i<weights.length;i++)
        {
            if(load+weights[i]>cap)
            {
                day++;
                load=weights[i];
            }
            else
            load+=weights[i];
        }
        return day;
    }
}
