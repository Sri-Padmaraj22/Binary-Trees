import java.util.Arrays;
public class AggressiveCows {
    public int find(int arr[],int cows)
    {
        Arrays.sort(arr);
        int ans=0;
        // low can also be minimum consequtive difference between adjacent elements in matrix
        int low=1,high=arr[arr.length-1]-arr[0];
        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(canWePlace(arr,mid,cows))
            {
                low=mid+1;
                ans=mid;
            }
            else
            high=mid-1;
        }
        return ans;
    }    
    public boolean canWePlace(int arr[],int dist,int cows)
    {
        int count=1,last=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]-last>=dist)
            {
                last=arr[i];
                count++;
            }
        }
        return count>=cows;
    }
}
