package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    class Pair
    {
        int first,second,time;
        Pair(int first,int second,int time)
        {
            this.first=first;
            this.second=second;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int visited[][]=new int[m][n];
        return bfs(grid,m,n,visited);
    }

    public int bfs(int [][]grid, int m,int n,int visited[][])
    {

        Queue<Pair> q=new LinkedList<Pair>();
        int fresh=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                else
                visited[i][j]=0;
                if(grid[i][j]==1)
                fresh++;
            }
        }
        int count=0;
        int ans=0;
        //The loop method for finding directions can also be used.
        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col=q.peek().second;
            int time=q.peek().time;
            ans=Math.max(ans,time);
            q.poll();
            if(row-1>=0 && grid[row-1][col]==1 && visited[row-1][col]==0)
            {
                visited[row-1][col]=2;
                q.add(new Pair(row-1,col,time+1));
                count++;
            }
            if(col+1<n && grid[row][col+1]==1 && visited[row][col+1]==0)
            {
                visited[row][col+1]=2;
                q.add(new Pair(row,col+1,time+1));
                count++;
            }
            if(row+1<m && grid[row+1][col]==1 && visited[row+1][col]==0)
            {
                visited[row+1][col]=2;
                q.add(new Pair(row+1,col,time+1));
                count++;

            }
            if(col-1>=0 && grid[row][col-1]==1 && visited[row][col-1]==0)
            {
                visited[row][col-1]=2;
                q.add(new Pair(row,col-1,time+1));
                count++;
            }
        }
        if(count!=fresh) return -1;
        return ans;
    }
}

