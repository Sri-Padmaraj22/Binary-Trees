package DP;

public class EvaluateBoolean {
  public int evaluate(String s)
  {
    int n=s.length();
    int dp[][][]=new int[n][n][2];
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<n;j++)
      {
        for(int k=0;k<2;k++)
          dp[i][j][k]=-1;
      }
    }
    return memo(0,n-1,s,dp,1);
  }
  public static int memo(int i,int j,String s,int dp[][][],int isTrue)
  {
    if(i>j) return 0;
    if(i==j)
    {
      if(isTrue==1)
      {
        if(s.charAt(i)=='T') return 1;
        else return 0;
      }
      if(!(s.charAt(i)=='T')) return 1;
        else return 0;
    }
    if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];
    int ways=0;
    for(int ind=i+1;ind<=j-1;ind+=2)
    {
      int LT=memo(i,ind-1,s,dp,1);
      int LF=memo(i,ind-1,s,dp,0);
      int RT=memo(ind+1,j,s,dp,1);
      int RF=memo(ind+1,j,s,dp,0);
      if(s.charAt(ind)=='&')
      {
        if(isTrue==1) ways+=LT*RT;
        else ways+=(LT*RF)+(LF*RT)+(LF*RF);
      }
      else if(s.charAt(ind)=='|')
      {
        if(isTrue==1) ways+=(LT*RT)+(LF*RT)+(LT*RF);
        else ways+=LF*RF;
      }
      else
      {
        if(isTrue==1) ways+=(LT*RF)+(RT*LF);
        else ways+=(LF*RF)+(LT*RT);
      }
    }
    return dp[i][j][isTrue]=ways;
  }
}
