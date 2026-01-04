package DP;
public class EditDistance {
  public int minDistance(String text1, String text2) {
       int n=text1.length();
       int m=text2.length();
       int dp[][]=new int[n][m];
       for(int i=0;i<n;i++)
       Arrays.fill(dp[i],-1);
       //return memo(n-1,m-1,text1,text2,dp);
       //return tabulation(text1,text2);
       return SpaceOptimized(text1,text2);
    }
    public int memo(int i,int j,String s1,String s2,int dp[][])
    {
        if(i<0) return j+1; //j+1 insertions needed to convert empty string to s2
        if(j<0) return i+1; //i+1 deletions needed to convert s1 to empty string
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return 0 +memo(i-1,j-1,s1,s2,dp);
        int insert=1+memo(i,j-1,s1,s2,dp);
        int delete=1+memo(i-1,j,s1,s2,dp);
        int replace=1+memo(i-1,j-1,s1,s2,dp);
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }

    public int tabulation(String s1,String s2)
    {
       int n=s1.length();
       int m=s2.length();
       int dp[][]=new int[n+1][m+1];
       for(int j=0;j<=m;j++)
       dp[0][j]=j;
       for(int i=0;i<=n;i++)
       dp[i][0]=i;

       for(int i=1;i<=n;i++)
       {
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1)) 
                dp[i][j]=dp[i-1][j-1];
                else
                {
                    int insert=1+dp[i][j-1];
                    int delete=1+dp[i-1][j];
                    int replace=1+dp[i-1][j-1];
                    dp[i][j]=Math.min(insert,Math.min(delete,replace));
                }
                
            }
       }
       return dp[n][m];
    }

    public int SpaceOptimized(String S1,String S2)
    {
        int n = S1.length();
        int m = S2.length();
        int[] prev = new int[m + 1];
        

        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            int[] cur = new int[m + 1];
            cur[0] = i;
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                } else {
                    cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
                }
            }
            prev=cur;
        }
        return prev[m];
    }
}
