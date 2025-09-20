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

    public static void main(String args[])
    {
        int a[]={1,2,3,4,};
        int b[]={1,3};
        Median ob=new Median();
        System.out.println(ob.median1(a,b));
    }
}
