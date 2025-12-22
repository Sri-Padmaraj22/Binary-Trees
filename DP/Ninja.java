package DP;
//import java.util.*;
public class Ninja
{
  public static int ninjaTraining(int n, int points[][]) {
        int dp[][]=new int[n][4];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<4;j++)
            points[i][j]=-1;
        }

        return ninjaTraining(n-1,3,points,dp);
        // Write your code here..
    }

    public static int ninjaTraining(int n,int last,int points[][],int dp[][])
    {
        if(n==0)
        {
            int maxi=0;
            for(int i=0;i<3;i++)
            {
                if(i!=last)
                maxi=Math.max(points[0][i],maxi);
                
            }
            return maxi;
        }
        if(dp[n][last]!=-1) return dp[n][last];
        
        int maxi=0;
        for(int i=0;i<3;i++)
        {
            int point=0;
            if(i!=last)
            {
                point=points[n][i]+ninjaTraining(n-1,i,points,dp);
                maxi=Math.max(point,maxi);
            }
        }
        return dp[n][last]=maxi;
    }

    //Tabulation
    public static int ninjaTraining2(int n, int points[][]) {
        int dp[][]=new int[n][4];
        dp[0][0]=Math.max(points[0][1],points[0][2]);
        dp[0][1]=Math.max(points[0][0],points[0][2]);
        dp[0][2]=Math.max(points[0][0],points[0][1]);
        dp[0][3]=Math.max(points[0][1],Math.max(points[0][0],points[0][2]));

        for(int day=0;day<n;day++)
          {
            for(int last=0;last<4;last++)
            {
              int maxi=0;
              dp[day][last]=0;
              for(int task=0;task<4;task++)
              {
                if(task!=last)
                {
                  int point=points[day][task]+dp[day-1][task];
                  maxi=Math.max(maxi,point);
                }
              }
              dp[day][last]=maxi;
            }
          }
        return dp[n-1][3];
        // Write your code here..
    }

    //Space Optimized
    public static int ninjaTraining3(int n, int points[][])
    {
       int dp[]=new int[4];
       dp[0]=Math.max(points[0][1],points[0][2]);
       dp[1]=Math.max(points[0][0],points[0][2]);
       dp[2]=Math.max(points[0][0],points[0][1]);
       dp[3]=Math.max(points[0][1],Math.max(points[0][0],points[0][2]));

       for(int day=1;day<n;day++)
       {
        int temp[]=new int[4];
        for(int last=0;last<n;last++)
        {
          temp[last]=0;
          int maxi=0;

          for(int task=0;task<4;task++)
          {
            if(last!=task)
            {
              int point=points[day][task]+dp[last];
              maxi=Math.max(point,maxi);
            }
          }
          temp[last]=maxi;
        }
        dp=temp;
       }
       return dp[n-1];
    }

    
}