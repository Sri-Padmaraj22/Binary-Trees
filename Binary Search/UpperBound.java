

public class UpperBound {
    public int UB(int arr[],int n,int target)
    {
        int low=0,high=n-1,ans=n;

        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(arr[mid]>target)
            {
                high=mid-1;
                ans=mid;
            }
            else
            low=mid+1;
        }
        return ans;
    }
}
