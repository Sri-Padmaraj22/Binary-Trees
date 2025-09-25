package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Islands {
    
    public class Pair{
        int first,second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public int numIslands(char [][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int visited[][] =new int[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==0 && grid[i][j]=='1')
                {
                    count++;
                    bfs(i,j,visited,grid);
                }

            }
        }
        return count;
    }
    public void bfs(int row,int col,int visited[][],char[][] grid)
    {
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(row,col));
        int n=grid.length;
        int m=grid[0].length;
        visited[row][col]=1;
        
        while(!q.isEmpty())
        {
            int ro=q.peek().first;
            int co=q.peek().second;
            q.poll();
            for(int deltarow=-1;deltarow<=1;deltarow++)
            {
                for(int deltacol=-1;deltacol<=1;deltacol++)
                {
                    int neighbourRow=ro+deltarow;
                    int neighbourCol=co+deltacol;
                    if(neighbourRow>=0 && neighbourRow<n && neighbourCol>=0 && neighbourCol<m && visited[neighbourRow][neighbourCol]==0 && grid[neighbourRow][neighbourCol]=='1')
                    {
                        visited[neighbourRow][neighbourCol]=1;
                        q.add(new Pair(neighbourRow,neighbourCol));
                        
                    }
                }
            }

        }

    }
}
