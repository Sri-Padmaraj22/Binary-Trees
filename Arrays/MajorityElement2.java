package Arrays;

public class MajorityElement2 {
  public int majorityElement(int[] arr) {
        int n=arr.length;
        int count=0,ele=0;
        for(int i=0;i<n;i++)
        {
            if(count==0)
            {
                ele=arr[i];
                count=1;
            }
            else if(ele==arr[i])
            {
                count++;
            }
            else
            count--;
        }
        return ele;
    }
}
