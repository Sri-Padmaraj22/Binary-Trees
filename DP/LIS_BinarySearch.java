package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LIS_BinarySearch {
   public int LIS(int[] nums) {
        int n = nums.length;
        
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        
        // Iterate on the elements of the array
        for (int i = 1; i < n; i++) {
            
            // If the current element can be added to the subsequence
            if (nums[i] > temp.get(temp.size() - 1)) 
                temp.add(nums[i]); 
                
            // Otherwise
            else {
                // Index at which the current element must be placed
                int ind = Collections.binarySearch(temp, nums[i]);
                if (ind < 0) ind = -(ind + 1);
                
                // Place the current element in the subsequence
                temp.set(ind, nums[i]);
            }    
        }
        
        // Return the length of temporary subsequence created so far
        return temp.size();
    }
}
