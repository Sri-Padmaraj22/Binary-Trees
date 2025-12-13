package Arrays;

public class Stocks {
  public int maxProfit(int[] arr) {
        
        int n=arr.length;
        int maxProfit=0;
        int min=arr[0];
        for(int i=1;i<n;i++)
        {
            int cost=arr[i]-min;
            maxProfit=Math.max(maxProfit,cost);
            min=Math.min(min,arr[i]);
        }
        return maxProfit;

    }
}
