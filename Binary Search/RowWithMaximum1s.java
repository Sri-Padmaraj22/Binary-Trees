public class RowWithMaximum1s
{
    public int lowerBound(int arr[],int n,int x)
    {
        int low=0,high=n-1;
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]>=x)
            {
                ans=mid;
                high=mid-1;
            }   
            else
            low=mid+1;
        }
        return ans;
    }

    public int find(int mat[][],int n,int m)
    {
        int max_count=0,index=-1;

        for(int i=0;i<n;i++)
        {
            int count=m-lowerBound(mat[i],m,1);

            if(count>max_count)
            {
                max_count=count;
                index=i;
            }
        }
        return index;
    }
    

}