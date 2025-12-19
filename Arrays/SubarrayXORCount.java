package Arrays;
import java.util.*;
public class SubarrayXORCount {
  public int subarraysWithXorK(int[] nums, int k) {
      int count=0;
      int n=nums.length;
      int XOR=0;
      //(XOR,count)
      Map<Integer,Integer> map=new HashMap<>();
      map.put(0,1);
      for(int i=0;i<n;i++)
      {
        XOR^=nums[i];
        if(map.containsKey(XOR^k))
          count+=map.get(XOR^k);
        map.put(XOR,map.getOrDefault(map.get(XOR),0)+1);
      }
      return count;
    }
}
