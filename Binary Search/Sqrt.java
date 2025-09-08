public class Sqrt {
    

    public static int find(int n)
    {
        int low=1;
        int high=n;
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(mid*mid>n)
            {
                high=mid-1;
            }
            if(mid*mid<=n)
            {
                ans=mid;
                low=mid+1;
            }

        }
        return ans;
    }

    public static void main(String args[])
    {
        int ans=find(50);
        System.out.println(ans);
    }
}
