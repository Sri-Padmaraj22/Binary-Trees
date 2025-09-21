public class Median {
    
    public double median1(int arr1[],int arr2[])
    {
        int n1=arr1.length,n2=arr2.length,i=0,j=0;
        int n=(n1+n2);
        int ind2=n/2;
        int ind1=ind2-1;
        int count=0;
        int ele1=-1,ele2=-1;
        while(i<n1 && j<n2)
        {
            if(arr1[i]<arr2[j])
            {
                if(count==ind1) ele1=arr1[i];
                if(count==ind2) ele2=arr1[i];
                count++;
                i++;
            }
            else{
                if(count==ind1) ele1=arr2[j];
                if(count==ind2) ele2=arr2[j];
                count++;
                j++;
            }
        }
        while(i<n1)
        {
            if(count==ind1) ele1=arr1[i];
            if(count==ind2) ele2=arr1[i];
            count++;
            i++;
        }
        while(j<n2)
        {
            if(count==ind1) ele1=arr2[j];
            if(count==ind2) ele2=arr2[j];
            count++;
            j++;
        }

        if(n%2==1)
        return (double)ele2;
        else
        return (double)((ele1+ele2)/2.0);
    }
    public double median2(int arr1[],int arr2[])
    {
       int n1=arr1.length,n2=arr2.length;
        if(n1>n2) return median2(arr2,arr1);
        int low=0,high=n1;
        int left=(n1+n2+1)/2;
        int n=n1+n2;
        while(low<=high)
        {
            int mid1=(low+high)>>1;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE,r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1<n1) r1=arr1[mid1];
            if(mid2<n2) r2=arr2[mid2];
            if(mid1-1>=0) l1=arr1[mid1-1];
            if(mid2-1>=0) l2=arr2[mid2-1];
            if(l1<=r2 && l2<=r1)
            {
                if(n%2==0)
                return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                else
                return (double) Math.max(l1,l2);
            }
            else if(l1>r2)
            {
                high=mid1-1;
            }
            else
            low=mid1+1;

        }
        return 0;
    }
    
}
