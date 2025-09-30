package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryMaze {
    class Pair{
        int dist,x,y;
        Pair(int dist,int x,int y)
        {
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
        return -1;
        int n=grid.length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,0));
        int distance[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        distance[0][0]=0;

        while(!q.isEmpty())
        {
            int x=q.peek().x;
            int y=q.peek().y;
            int dist=q.peek().dist;
            q.poll();
            if(x==n-1 && y==n-1) return dist+1;
            for(int i=-1;i<=1;i++)
            {
                for(int j=-1;j<=1;j++)
                {
                    int nx=x+i;
                    int ny=y+j;
                    if(nx>=0 && ny>=0 && nx<n && ny<n && grid[nx][ny]==0)
                    {
                        if(dist+1<distance[nx][ny])
                        {
                            distance[nx][ny]=dist+1;
                            q.add(new Pair(distance[nx][ny],nx,ny));
                        }
                    }
                }
            }
        }
        return -1;

    }
}

