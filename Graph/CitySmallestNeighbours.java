package Graph;
public class CitySmallestNeighbours{
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int count=0,city=-1,maxCount=n;
        int m=edges.length;
        int dist[][]= new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<m;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        for(int i=0;i<n;i++)dist[i][i]=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(dist[j][i]==Integer.MAX_VALUE || dist[i][k]==Integer.MAX_VALUE) continue;
                    dist[j][k]=Math.min(dist[j][k],dist[j][i]+dist[i][k]);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            count=0;
            for(int j=0;j<n;j++)
            {
                if(dist[i][j]<=distanceThreshold)
                {
                    count++;
                }
            }
            if(count<=maxCount)
            {
                city=i;
                maxCount=count;
            }
        }
        return city;
    }
}
