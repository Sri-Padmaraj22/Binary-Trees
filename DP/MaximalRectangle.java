package DP;

import java.util.Stack;

public class MaximalRectangle
{
  public int largestRectangle(int height[])
    {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=height.length;i++)
        {
            while(!st.isEmpty() && (i==height.length || height[st.peek()]>=height[i]))
            {
                int h=height[st.peek()];
                st.pop();
                int w;
                if(st.isEmpty()) w=i;
                else w=i-st.peek()-1;
                maxArea=Math.max(maxArea,w*h);

            }
            st.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int height[]=new int[m];
        int maxArea=(int)-1e9;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }
            int area=largestRectangle(height);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
}