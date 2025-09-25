package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    
    class Pair
    {
        int first,second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int original=image[sr][sc];
        image[sr][sc]=color;
        int visited[][]=new int[m][n];
        bfs(image,sr,sc,color,original,visited);
        return image;
    }
      public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        int ans[][]=image;
        int original=image[sr][sc];
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        int m=image.length;
        int n=image[0].length;
        dfs(image,sr,sc,original,color,ans,delrow,delcol,m,n);
        return ans;
    }
    public void bfs(int [][]image,int sr,int sc,int color,int original,int visited[][])
    {
        int m=image.length;
        int n=image[0].length;
        visited[sr][sc]=1;
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(sr,sc));

        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col=q.peek().second;
            q.poll();
            if(row-1>=0 && image[row-1][col]==original && visited[row-1][col]!=1)
            {
                visited[row-1][col]=1;
                image[row-1][col]=color;
                q.add(new Pair(row-1,col));
            }
            if(col+1<n && image[row][col+1]==original && visited[row][col+1]!=1)
            {
                visited[row][col+1]=1;
                image[row][col+1]=color;
                q.add(new Pair(row,col+1));

            }
            if(row+1<m && image[row+1][col]==original && visited[row+1][col]!=1)
            {
                visited[row+1][col]=1;
                image[row+1][col]=color;
                q.add(new Pair(row+1,col));

            }
            if(col-1>=0 && image[row][col-1]==original && visited[row][col-1]!=1)
            {
                visited[row][col-1]=1;
                image[row][col-1]=color;
                q.add(new Pair(row,col-1));

            }
        }   
    }
    public void dfs(int image[][],int sr,int sc,int original,int color,int ans[][],int delrow[],int delcol[],int m,int n)
    {
        ans[sr][sc]=color;
        for(int i=0;i<4;i++)
        {
            int neighbourRow=sr+delrow[i];
            int neighbourCol=sc+delcol[i];

            if(neighbourRow>=0 && neighbourCol>=0 && neighbourRow<m && neighbourCol<n && ans[neighbourRow][neighbourCol]!=color && image[neighbourRow][neighbourCol]==original)
            {
                dfs(image,neighbourRow,neighbourCol,original,color,ans,delrow,delcol,m,n);
            }
        }
    }
}
