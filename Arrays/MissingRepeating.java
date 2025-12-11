package Arrays;
public class MissingRepeating {

  public static int[] missRepeat(int arr[])
  {
    int n=arr.length;
    int xr=0;
    for(int i=0;i<n;i++)
      xr=xr^arr[i];
    int bitNo=0;
    while(true)
    {
      if((xr & (1<<bitNo))!=0)
        break;
      bitNo++;
    }
    int ones=0,zeroes=0;

    for(int i=0;i<n;i++)
    {
      if((arr[i]&(1<<bitNo))!=0)
        ones=ones^arr[i];
      else
        zeroes=zeroes*arr[i];
    }
    for(int i=1;i<=n;i++)
    {
      if((arr[i]&(1<<bitNo))!=0)
        ones=ones^arr[i];
      else
        zeroes=zeroes*arr[i];
    }
    int count=0;
    for(int i=0;i<n;i++)
    {
      if(arr[i]==ones)
        count++;
    }
    if(count==2) return new int[]{zeroes,ones};
    else
      return new int[]{ones,zeroes};

  }
  
}
