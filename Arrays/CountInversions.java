package Arrays;
public class CountInversions {
  
    public static int count(int arr[])
    {
        return mergeSort(arr,0,arr.length-1);
    }

    public static int mergeSort(int arr[],int low,int high)
    {
        int cnt=0;
        if(low>=high)
            return cnt;
        int mid=(low+high)/2;
        cnt+=mergeSort(arr,low,mid);
        cnt+=mergeSort(arr,mid+1,high);
        cnt+=merge(arr,low,mid,high);
        return cnt;
    }

    public static int merge(int arr[],int low,int high,int mid)
    {
        int cnt=0;
        int temp[]=new int[arr.length];
        int left=low,right=mid+1;
        int index=0;
        while(left<=mid && right<=high)
        {
            if(arr[left]<arr[right])
            {
                temp[index++]=arr[left];
                left++;
            }
            else{
                temp[index++]=arr[right];
                cnt=cnt+(mid-left+1);
                right++;
            }
        }
        while(left<=mid)
        {
            temp[index++]=arr[left];
            left++;
        }
        while(right<=high)
        {
            temp[index++]=arr[right];
            right++;
        }
        for(int i=low;i<high;i++)
        {
            arr[i]=temp[i];
        }
        return cnt;
    }
}
