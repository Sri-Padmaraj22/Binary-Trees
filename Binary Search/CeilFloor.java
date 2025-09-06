

public class CeilFloor {
    public int ceil(int arr[],int n,int target)
    {
        int low=0,high=n-1,ans=0;

        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(arr[mid]>=target)
            {
                high=mid-1;
                ans=mid;
            }
            else
            low=mid+1;
        }
        return ans;
    }
    public int floor(int arr[],int n,int target)
    {
        int low=0,high=n-1,ans=0;

        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(arr[mid]<=target)
            {
                low=mid+1;
                ans=mid;
            }
            else
            high=mid-1;
        }
        return ans;
    }

    
}
