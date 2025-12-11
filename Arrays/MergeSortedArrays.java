package Arrays;

public class MergeSortedArrays {
   public void merge(int[] arr1, int m, int[] arr2, int n) {
        
        int gap=(m+n)/2+(m+n)%2;
        int len=m+n;
        while(gap>0)
        {
            int left=0;
            int right=left+gap;
            while(right<len)
            {
                if(left<n && right>=n)
                {
                    int temp=arr1[left];
                    arr1[left]=arr2[right-m];
                    arr2[right-m]=temp;
                }
                else if(left>=m)
                {
                    int temp=arr1[left-m];
                    arr1[left-m]=arr2[right-m];
                    arr2[right-m]=temp;
                }
                if(left<n && right<n)
                {
                    int temp=arr1[left];
                    arr1[left]=arr2[right];
                    arr2[right]=temp;
                }
                left++;
                right++;
            }
            if(gap==1) break;
            gap=gap/2+gap%2;
        }
    }
}
