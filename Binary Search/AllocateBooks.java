public class AllocateBooks {
    
    public int allocate(int arr[],int m)
    {
        int n=arr.length;
        if(n<m) return -1;
        int low=0,high=0,ans=0;
        for(int i=0;i<n;i++)
        {
            low=Math.max(low,arr[i]);
            high+=arr[i];
        }
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(helper(arr,mid)<=m)
            {
                low=mid+1;
                ans=mid;
            }
            else
            high=mid-1;
        }
        return ans;
    }
    public int helper(int arr[],int pages)
    {
        int student=1,countPages=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]+countPages<=pages)
            {
                countPages+=arr[i];
            }
            else
            {
                student++;
                countPages=arr[i];
            }
        }
        return student;
    }
}
