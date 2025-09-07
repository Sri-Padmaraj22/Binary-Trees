public class MinRotatedSort {
    
    public int solution(int arr[])
    {
        int low=0;
        int n=arr.length;
        int high=n-1;
        int min=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(arr[low]<=arr[high])
            {
                min=Math.min(min,arr[low]);
                break;
            }
            if(arr[low]<=arr[mid])
            {
                min=Math.min(arr[low],min);
                low=mid+1;
            }
            if(arr[mid]<=arr[high]);
            {
                min=Math.min(arr[mid],min);
                high=mid-1;
            }

        }

        return min;
    }
}
