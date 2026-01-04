package DP;

public class DeleteOperationConvert {
  public int minDistance(String text1, String text2) {
        int N=text1.length();
        int M=text2.length();
        int dp[]=new int[M+1];
        for(int j=0;j<=M;j++)
        dp[j]=0;

        for(int i=1;i<=N;i++)
        {
            int temp[]=new int[M+1];
            for(int j=1;j<=M;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    temp[j]=1+dp[j-1];
                }
                else
                {
                    temp[j]=Math.max(dp[j],temp[j-1]);
                }
            }
            dp=temp;
        }
        return N-dp[M]+M-dp[M];
    }
}
