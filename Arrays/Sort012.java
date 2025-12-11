package Arrays;
public class Sort012 {
  public void sortColors(int[] nums) {
        int n=nums.length;
        int mid=0,low=0,high=n-1;

        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                int t=nums[low];
                nums[low]=nums[mid];
                nums[mid]=t;
                low++;
                mid++;
            }
            else if(nums[mid]==1)
            mid++;
            else
            {
                int t=nums[mid];
                nums[mid]=nums[high];
                nums[high]=t;
                high--;
            }
        }
    }
}
