package DP;
import java.util.*;
public class LCA
{
  public int longestCommonSubsequence(String text1, String text2) {
        int N=text1.length();
        int M=text2.length();
        int dp[][]=new int[N][M];
        for(int i=0;i<N;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        //return memo(N-1,M-1,dp,text1,text2);
        //return tabulation(text1,text2);
        return space(text1,text2);
    }

    public int memo(int ind1,int ind2,int dp[][],String s1,String s2)
    {
        if(ind1<0 || ind2<0)
        return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

        if(s1.charAt(ind1)==s2.charAt(ind2))
        return dp[ind1][ind2]= 1 + memo(ind1-1,ind2-1, dp, s1,s2);

        return dp[ind1][ind2]= 0+ Math.max(memo(ind1-1,ind2, dp, s1,s2),memo(ind1,ind2-1, dp, s1,s2));
    }

    public int tabulation(String text1,String text2)
    {
        int N=text1.length();
        int M=text2.length();
        int dp[][]=new int[N+1][M+1];

        for(int i=0;i<=N;i++)
        dp[i][0]=0;
        for(int j=0;j<=M;j++)
        dp[0][j]=0;

        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=M;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[N][M];
    }

    public int space(String text1,String text2)
    {
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
        return dp[M];
    }
}