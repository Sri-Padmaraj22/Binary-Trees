package DP;

import java.util.*;

public class MinCostToCut{
  public int minCost(int n, int[] cuts) {
        ArrayList<Integer> cuts1=new ArrayList<>();
        for(int a:cuts)
        cuts1.add(a);
        cuts1.add(0);
        cuts1.add(n);
        Collections.sort(cuts1);
        int m=cuts1.size();
        int dp[][]=new int[m+1][m+1];
        for(int i=0;i<m+1;i++)
        Arrays.fill(dp[i],-1);
        //return f(1,m-2,cuts1,dp); 
        return f1(n,cuts1);
    }
    public int f(int i,int j,ArrayList<Integer> cuts,int dp[][])
    {
        if(i>j) return 0;
        int mini=(int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i;ind<=j;ind++)
        {
            int cost = cuts.get(j + 1) - cuts.get(i - 1) + f(i, ind - 1, cuts,dp) + f(ind + 1, j, cuts,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }

    public int f1(int n,ArrayList<Integer> cuts)
    {
        int c = cuts.size() - 2; // number of cuts excluding ends

        // Create DP table initialized with 0
        int[][] dp = new int[c + 2][c + 2];

        // Fill DP table for all segments
        for (int i = c; i >= 1; i--) {
            for (int j = i; j <= c; j++) {
                int mini = Integer.MAX_VALUE;

                // Try making a cut at every position between i and j
                for (int ind = i; ind <= j; ind++) {
                    // Cost of current cut plus left and right subproblems
                    int ans = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];

                    // Update minimum cost
                    mini = Math.min(mini, ans);
                }

                // Store minimum cost in DP table
                dp[i][j] = mini;
            }
        }

        // Return minimum cost to cut between indices 1 and c
        return dp[1][c];
    }
}