package DP;
public class MinimumFallingPath {
  public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        //int min=Integer.MAX_VALUE;
        if(n==1) return matrix[0][0];
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        /*for(int i=0;i<n;i++)
        {
            int sum=helper(0,i,matrix,dp);
            min=Math.min(min,sum);
        }   
        return min;*/
        return helper3(matrix);
    }

    public int helper(int i,int j,int mat[][],int dp[][])
    {
        int n=mat.length;
        if(i==n-1)
        return dp[i][j]=mat[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        //diagonally left
        int left=Integer.MAX_VALUE;
        if(j>0)
        left=helper(i+1,j-1,mat,dp);

        //diagonally right
        int right=Integer.MAX_VALUE;
        if(j<n-1)
        right=helper(i+1,j+1,mat,dp);

        //bottom
        int bottom=helper(i+1,j,mat,dp);
        return dp[i][j]= Math.min(left,Math.min(right,bottom))+mat[i][j];
    }

    //Tabulation
    public int helper2(int mat[][])
    {
        int n=mat.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        dp[0][i]=mat[0][i];

        for(int row=1;row<n;row++)
        {
            for(int col=0;col<n;col++)
            {

                int left=mat[row][col];
                if(col-1>=0) left+=dp[row-1][col-1];
                else left+=(int)1e9;

                int bottom=mat[row][col]+dp[row-1][col];

                int right=mat[row][col];
                if(col+1<n) right+=dp[row-1][col+1];
                else right+=(int)1e9;

                dp[row][col]=Math.min(left,Math.min(right,bottom));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int sum=dp[n-1][i];
            min=Math.min(min,sum);
        }   
        return min;
    }

    //Space Optimization
    public int helper3(int mat[][])
    {
        int n=mat.length;
        int dp[]=new int[n];
        for(int i=0;i<n;i++)
        dp[i]=mat[0][i];
        for(int row=1;row<n;row++)
        {
            int temp[]=new int[n];
            for(int col=0;col<n;col++)
            {
                int left=mat[row][col];
                if(col-1>=0) left+=dp[col-1];
                else left+=(int)1e9;

                int bottom=mat[row][col]+dp[col];

                int right=mat[row][col];
                if(col+1<n) right+=dp[col+1];
                else right+=(int)1e9;

                temp[col]=Math.min(left,Math.min(right,bottom));
            }
            dp=temp;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int sum=dp[i];
            min=Math.min(min,sum);
        }   
        return min;
    }
}
