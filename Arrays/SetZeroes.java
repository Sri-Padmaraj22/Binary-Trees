package Arrays;

public class SetZeroes {
  public void setZeroes(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        int col0=arr[0][0];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==0)
                {
                    arr[i][0]=0;
                    if(j!=0)
                    arr[0][j]=0;
                    else
                    col0=0;
                }

            }
        }

        for(int i=m-1;i>=1;i--)
        {
            for(int j=n-1;j>=1;j--)
            {
                if(arr[0][j]==0 || arr[i][0]==0)
                {
                    arr[i][j]=0;
                }
            }
        }
        if(arr[0][0]==0)
        {
            for(int j=0;j<n;j++)
            arr[0][j]=0;
        }
        if(col0==0)
        {
            for(int i=0;i<m;i++)
            {
                arr[i][0]=0;
            }
        }

    }
}
