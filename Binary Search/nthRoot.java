public class nthRoot {
    
    public static int helper(int mid,int n)
    {
        int ans=1;

        while(n>0)
        {
            if(n%2==1)
            {
                n=n-1;
                ans*=mid;
            }
            else{
                mid*=mid;
                n=n/2;
            }

        }
        return ans;
    }
    public static int solution(int n,int k)
    {
        int low=1;
        int high=n;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int midroot=helper(mid, k);
            if(midroot==n)
            return mid;
            else if(midroot>n)
            high=mid-1;
            else
            low=mid+1;
        }
        return -1;

    }
    public static void main(String args[])
    {
        int ans=solution(27, 3);
        System.out.println(ans);

        
    }
}
