package Arrays;
import java.util.*;
public class FourSum {
  public static List<List<Integer>> find(int arr[],int target)
  {
    int n=arr.length;
    List<List<Integer>> res=new ArrayList<>();
    
    for(int i=0;i<n;i++)
    {
      for(int j=i+1;j<n;j++)
      {
        int k=j+1;
        int l=n-1;
        while(k<l)
        {
          int sum=arr[i]+arr[j];
          sum+=arr[k];
          sum+=arr[l];

          if(sum<target) k++;
          else if(sum>target) l--;
          else
          {
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(arr[i]);
            temp.add(arr[j]);
            temp.add(arr[k]);
            temp.add(arr[l]);
            res.add(temp);
            k++;
            l--;
            while(arr[k]==arr[k-1]) k++;
            while(arr[l]==arr[l+1])l--;
          }
        }
      }
    }
    return res;
  }
}
