package DP;

import java.util.Arrays;

public class LongestStringChain {
   public boolean checkPossible(String largest,String smallest)
    {
        if(smallest.length()+1!=largest.length()) return false;
        int i=0,j=0;
        while(i<largest.length())
        {
            if(j<smallest.length()&&largest.charAt(i)==smallest.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        if(i==largest.length() && j==smallest.length())
        return true;
        else return false;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(),b.length()));
        int n=words.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        System.out.println(Arrays.toString(words));
        int maxi=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(checkPossible(words[i],words[j])&& dp[j]+1>dp[i])
                {
                    dp[i]=dp[j]+1;
                }

            }
            maxi=Math.max(dp[i],maxi);
        }
        return maxi;
    }
}
