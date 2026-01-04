package DP;

import java.util.*;

public class WildcardMatching {
  public boolean isMatch(String s, String p) {

        int n=p.length();
        int m=s.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        Arrays.fill(dp[i],-1);

        //return memo(n-1,m-1,p,s,dp);
        return tabulation(p,s);
    }

    public boolean memo(int i,int j,String S1,String S2,int dp[][])
    {
        // Base Case 1: Both pattern and text are fully matched
        if (i < 0 && j < 0) return true;

        // Base Case 2: Pattern exhausted but text still remains
        if (i < 0 && j >= 0) return false;

        // Base Case 3: Text exhausted but pattern may have '*' left
        if (j < 0 && i >= 0)
        {
            for(int x=0;x<=i;x++)
            {
                if(S1.charAt(x)!='*')
                return false;
            }
            return true;
        }

        // If already computed, return stored result
        if (dp[i][j] != -1) return dp[i][j] == 1;

        // If characters match or pattern has '?'
        if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?')
            dp[i][j] = memo(i - 1, j - 1, S1,S2,dp) ? 1 : 0;

        // If pattern has '*', check both possibilities
        else if (S1.charAt(i) == '*')
            dp[i][j] = (memo(i-1,j,S1,S2,dp) ||
                        memo(i,j-1,S1,S2,dp)) ? 1 : 0;

        // If characters don't match
        else
            dp[i][j] = 0;

        return dp[i][j] == 1;
    }
    public boolean isAllStars(String S1, int i) {
        // Loop through the first i characters
        for (int j = 1; j <= i; j++) {
            // If any character is not '*', return false
            if (S1.charAt(j - 1) != '*')
                return false;
        }
        // All were '*', so return true
        return true;
    }
    public boolean tabulation(String S1, String S2) {
        // Get lengths of pattern and text
        int n = S1.length();
        int m = S2.length();

        // Create a DP table where dp[i][j] tells if pattern[0...i-1] matches text[0...j-1]
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case: empty pattern matches empty string
        dp[0][0] = true;

        // Base case: empty pattern cannot match non-empty string
        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }

        // Base case: pattern can match empty string only if it contains all '*'
        for (int i = 1; i <= n; i++) {
            dp[i][0] = isAllStars(S1, i);
        }

        // Fill the DP table row by row
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // Case 1: Characters match exactly or pattern has '?'
                if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // Case 2: Pattern has '*'
                else if (S1.charAt(i - 1) == '*') {
                    // '*' matches zero characters (dp[i-1][j]) OR
                    // '*' matches one/more characters (dp[i][j-1])
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }

                // Case 3: No match
                else {
                    dp[i][j] = false;
                }
            }
        }

        // Final answer is stored at dp[n][m]
        return dp[n][m];
    }
}
