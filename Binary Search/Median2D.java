public class Median2D {
    
    public int median(int mat[][])
    {
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++)
        {
            low=Math.min(low,mat[i][0]);
            high=Math.max(high,mat[i][m-1]);
        }
        int req=(m*n)/2;
        while(low<=high)
        {
            int mid=(low+high)>>1;
            int count=helper(mat,n,m,mid);
            if(count<=req)
            low=mid+1;
            else
            high=mid-1;

        }


        return low;
    }

    public int helper(int mat[][],int n,int m,int mid)
    {
        int count=0;
        for(int i=0;i<n;i++)
        {
            count+=upperbound(mat[i],mid);

        }
        return count;
    }
    public int upperbound(int arr[],int target)
    {
        int low=0,high=arr.length-1;
        int ans=0;
        while(low<=high)
        {
            int mid=(low+high)>>1;
            if(arr[mid]>target)
            {
                ans=mid;
                high=mid-1;

            }
            else
            low=mid+1;
        }
        return ans;
    }
}
