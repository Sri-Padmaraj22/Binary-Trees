

public class FirstLastOccurence {
    public int[] searchRange(int[] nums, int target) {
        int first=firstOccurence(nums,nums.length,target);
        if(first==-1) return new int[]{-1,-1};
        int last=lastOccurence(nums,nums.length,target);
        return new int[]{first,last};
    }
    public int firstOccurence(int arr[],int n,int target)
    {
        int low=0;
        int high=n-1;
        int first=-1;
        while(low<=high)
        {
            int mid=low +(high-low)/2;
            if(arr[mid]==target) 
            {
                first=mid;
                high=mid-1;
            }
            else if(arr[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return first;
    }
    public int lastOccurence(int arr[],int n,int target)
    {
        int low=0;
        int high=n-1;
        int last=-1;
        while(low<=high)
        {
            int mid=low +(high-low)/2;
            if(arr[mid]==target) 
            {
                last=mid;
                low=mid+1;
            }
            else if(arr[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return last;
    }
}
