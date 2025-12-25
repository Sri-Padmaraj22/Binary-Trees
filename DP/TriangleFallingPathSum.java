package DP;
import java.util.*;
public class TriangleFallingPathSum {
  public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        //return minimumTotal(0,0,triangle,dp);
        return helper2(triangle);
    }
    //Memoization
    public int minimumTotal(int row,int col,List<List<Integer>> triangle,int dp[][])
    {
        if(row==triangle.size()-1) return triangle.get(row).get(col);
        if(dp[row][col]!=-1) return dp[row][col];
        int bottom=triangle.get(row).get(col)+minimumTotal(row+1,col,triangle,dp);
        int right=triangle.get(row).get(col)+minimumTotal(row+1,col+1,triangle,dp);
        return dp[row][col]=Math.min(bottom,right);
    }
    //Tabulation
    public int helper(List<List<Integer>> triangle)
    {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            dp[n-1][i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<=i;j++)
            {
                int bottom=triangle.get(i).get(j)+dp[i+1][j];
                int right=triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(bottom,right);
            }
        }

        return dp[0][0];
    }

    //Space Optimization

    public int helper2(List<List<Integer>> triangle)
    {
        int n=triangle.size();
        List<Integer> dp=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            dp.add(triangle.get(n-1).get(i));
        }
        for(int i=n-2;i>=0;i--)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                int bottom=triangle.get(i).get(j)+dp.get(j);
                int right=triangle.get(i).get(j)+dp.get(j+1);
                temp.add(Math.min(bottom,right));
            }
            dp=temp;
        }

        return dp.get(0);
    }
}
