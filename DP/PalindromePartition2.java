package DP;
public class PalindromePartition2 {
   public int minCut(String s) {
        int n=s.length();
        int dp[]=new int[n];
        for(int i=0;i<n;i++)
        dp[i]=-1;
        //return memo(0,s,dp)-1;
        //return tabulation(s);
        return minCut2(s);
    }

    public boolean isPalin(String s)
    {
        int i=0,j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
    public int memo(int i, String s,int dp[])
    {
        if(i==s.length()) return 0;
        if(dp[i]!=-1) return dp[i];
        String temp=""; int mini=(int)1e9;
        for(int j=i;j<s.length();j++)
        {
            temp+=s.charAt(j);
            if(isPalin(temp))
            {
                int cost=1+memo(j+1,s,dp);
                mini=Math.min(cost,mini);
            }
        }
        return dp[i]=mini;
    }

    public int tabulation(String s)
    {
        int n=s.length();
        int dp[]=new int[n+1];
        for(int i=n-1;i>=0;i--)
        {
            String temp=""; int mini=(int)1e9;
            for(int j=i;j<n;j++)
            {
                temp+=s.charAt(j);
                if(isPalin(temp))
                {
                    int cost=1+dp[j+1];
                    mini=Math.min(cost,mini);
                }
            }
            dp[i]=mini;
        }
        return dp[0]-1;
    }

    public int minCut2(String s) {
    char[] c = s.toCharArray();
    int n = c.length;
    int[] cut = new int[n];
    boolean[][] pal = new boolean[n][n];
    
    for(int i = 0; i < n; i++) {
        int min = i;
        for(int j = 0; j <= i; j++) {
            if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                pal[j][i] = true;  
                min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
            }
        }
        cut[i] = min;
    }
    return cut[n - 1];
}
}
