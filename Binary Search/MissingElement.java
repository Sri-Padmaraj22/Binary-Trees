public class MissingElement
{
    public int findKthPositive(int[] arr, int k) {
        int low=0,high=arr.length-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k)
            {
                low=mid+1;
            }
            else
            high=mid-1;
        }
        if(high!=-1)
        {
            int missing=arr[high]-(high+1);
            int more=k-missing;
            return arr[high]+more;
        }
        else
        {
            int ans=0;
            for(int i=1;i<arr[0];i++)
            {
                ans++;
                k--;
                if(k==0)
                break;
            }
            return ans;
        }
    }
     public int findKthPositive2(int[] arr, int k) {
        int low=0,high=arr.length-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k)
            {
                low=mid+1;
            }
            else
            high=mid-1;
        }
        return low+k; // return high+1+k;
    }
}