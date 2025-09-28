package Graph;
import java.util.*;
class BipartiteGraphDFS {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(!dfs(i,0,color,graph))
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int start,int code,int colour[],int graph[][])
    {
        colour[start]=code;
        for(int element:graph[start])
        {
            if(colour[element]==-1)
            {
                if(dfs(element,1-code,colour,graph)==false)
                return false;
            }
            else if(colour[element]==code)
            return false;
        }
        return true;

    }
    
}

