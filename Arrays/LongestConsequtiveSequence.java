package Arrays;
import java.util.*;
public class LongestConsequtiveSequence {
  
  public static int longestSequence(int arr[])
  {
    int longest=0;
    int n=arr.length;
    int currCount=0,lastSmaller=Integer.MIN_VALUE;

    Arrays.sort(arr);
    for(int i=0;i<n;i++)
    {     
      if(arr[i]-1==lastSmaller)
      {
        lastSmaller=arr[i];
        currCount++;
      }
      else if(lastSmaller!=arr[i])
      {
        currCount=1;
        lastSmaller=arr[i];
      }
      longest=Math.max(longest,currCount);
    }
    return longest;
  }
  public static int longestSequenceOptimal(int arr[])
  {
    int longest=1;
    int n=arr.length;
    if(n==0)
      return 0;
    Set<Integer> set=new HashSet<>();
    for(int i=0;i<n;i++)
      set.add(arr[i]);


    for(int ele:set)
    {
      if(!set.contains(ele-1))
      {
        int count=1;
        int x=ele;
        while(set.contains(x+1))
        {
          x=x+1;
          count++;
        }
        longest=Math.max(longest,count);
      }
    }
    return longest;
  }
}
