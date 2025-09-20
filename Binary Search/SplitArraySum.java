class SplitArraySum {
    public int splitArray(int[] arr, int k) {
        int low=Integer.MAX_VALUE,high=0,ans=0,max=0;
        for(int i=0;i<arr.length;i++)
        {
            high+=arr[i];
            low=Math.min(low,arr[i]);
            max=Math.max(max,arr[i]);
        }
        if(arr.length==k)
        return max;
        low=max;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(findCount(arr,mid)>k)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
                ans=mid;
                
            }
            

        }
        return ans;
    }

    public int findCount(int arr[],int mid)
    { 
        int count=1; int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            if(sum+arr[i]<=mid)
            {
                sum+=arr[i];
            }
            else
            {
                count++;
                sum=arr[i];
            }
        }
        return count;
    }
}