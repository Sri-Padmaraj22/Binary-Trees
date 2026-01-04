package DP;

public class MinInsertionsPalindromic {
  public int minInsertions(String s) {
        StringBuilder sb=new StringBuilder();
        String s2=sb.append(s).reverse().toString();
        int len=s2.length();
        int dp[]=new int[len+1];

        for(int i=1;i<=len;i++)
        {
            int temp[]=new int[len+1];
            for(int j=1;j<=len;j++)
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
        return len-dp[len];
    }
}
