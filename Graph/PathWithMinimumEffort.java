package Graph;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    class Tuple{
        int difference,x,y;
        Tuple(int difference,int x,int y)
        {
            this.difference=difference;
            this.x=x;
            this.y=y;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int rows=heights.length;
        int columns=heights[0].length;
        PriorityQueue<Tuple> q= new PriorityQueue<Tuple>((x,y)-> x.difference-y.difference);
        int dist[][]=new int[rows][columns];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        dist[0][0]=0;
        q.add(new Tuple(0,0,0));
        while(!q.isEmpty())
        {
            Tuple t= q.poll();
            int difference=t.difference;
            int x=t.x;
            int y=t.y;
            if(x==rows-1 && y==columns-1) return difference;
            for(int i=0;i<4;i++)
            {
                int nx=x+delrow[i];
                int ny=y+delcol[i];
                if(nx>=0 && ny>=0 && nx<rows && ny<columns)
                {
                    int diff=Math.abs(heights[x][y]-heights[nx][ny]);
                    diff=Math.max(difference,diff);
                    if(diff<dist[nx][ny])
                    {
                        dist[nx][ny]=diff;
                        q.add(new Tuple(dist[nx][ny],nx,ny));
                    }
                }
            }
        }
        return 0;
    }
}
