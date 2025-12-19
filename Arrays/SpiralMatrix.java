package Arrays;
import java.util.*;
public class SpiralMatrix {
  public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0,left=0,right=m-1,bottom=n-1;
     while(top<=bottom && left<=right){
        //right
        for(int i=left;i<=right;i++)
        {
            res.add(matrix[top][i]);
        }
        top++;
        //bottom
        for(int i=top;i<=bottom;i++)
        {
            res.add(matrix[i][right]);
        }
        right--;
        //left
        if(top<=bottom){
        for(int i=right;i>=left;i--)
        {
            res.add(matrix[bottom][i]);
        }
        bottom--;
        }
        //top
        if(left<=right)
        {
        for(int i=bottom;i>=top;i--)
        {
            res.add(matrix[i][left]);
        }
        left++;
        }
    }

    return res;
    }
}
