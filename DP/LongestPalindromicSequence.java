package DP;

public class LongestPalindromicSequence{
  public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        String s2=sb.reverse().toString();
        int dp[]=new int[s.length()+1];
        
        for(int i=1;i<=s.length();i++)
        {
            int temp[]=new int[s.length()+1];
            for(int j=1;j<=s.length();j++)
            {
                if(s.charAt(i-1)==s2.charAt(j-1))
                {
                    temp[j]=1+dp[j-1];
                }
                else
                {
                    temp[j]=Math.max(temp[j-1],dp[j]);
                }
            }
            dp=temp;
            
        }
        return dp[s.length()];
    }
}