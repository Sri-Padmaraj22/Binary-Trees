package Arrays;
import java.util.*;
public class PascalTriangle {
   public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> res=new ArrayList<>();
       for(int row=1;row<=numRows;row++)
       {
        int ans=1;
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(ans);
        for(int col=1;col<row;col++)
        {
            ans=ans*(row-col);
            ans/=col;
            temp.add(ans);
        }
        res.add(temp);
       }
       return res;
    }
}
