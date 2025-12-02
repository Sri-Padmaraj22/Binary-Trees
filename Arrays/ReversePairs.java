package Arrays;

import java.util.ArrayList;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    public int mergeSort(int nums[],int low,int high)
    {
        if(low>=high) return 0;
        int mid=(low+high)/2;
        int count=mergeSort(nums,low,mid);
        count+=mergeSort(nums,mid+1,high);
        count+=countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return count;
    }
    public int countPairs(int nums[],int low,int mid,int high)
    {
        int count=0;
        int right=mid+1;
        for(int i=low;i<=mid;i++)
        {
            while(right<=high && (long) nums[i]>2L *nums[right])
            right++;
            count+=(right-(mid+1));
        }
        return count;
    }

    public void merge(int arr[],int low,int mid,int high)
    {
        ArrayList<Integer> temp=new ArrayList<>();
        int left=low,right=mid+1;
        while(left<=mid && right<=high)
        {
            if(arr[left]<=arr[right])
            {
                temp.add(arr[left]);
                left++;
            }
            else
            {
                temp.add(arr[right]);
                right++;
            }
        }

        while(left<=mid)
        {
            temp.add(arr[left++]);
        }
        while(right<=high)
        {
            temp.add(arr[right++]);
        }
        for(int i=low;i<=high;i++)
        arr[i]=temp.get(i-low);
    }
}
