package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergingSubIntervals {
   public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]> ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        ans.add(intervals[0]);
        for(int i=1;i<n;i++)
        {
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(ans.get(ans.size()-1)[1]>=start)
            {
                int prevEnd=ans.get(ans.size()-1)[1];
                prevEnd=Math.max(prevEnd,end);
                ans.get(ans.size()-1)[1]=prevEnd;
            }
            else
            ans.add(new int[]{start,end});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
