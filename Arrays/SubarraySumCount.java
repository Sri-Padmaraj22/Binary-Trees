package Arrays;
import java.util.*;
public class SubarraySumCount {
  public int subarraySum(int[] nums, int k) {
        int count=0;
        int n=nums.length;
        //(PrefixSum,Count)
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(map.containsKey(sum-k))
            count+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
