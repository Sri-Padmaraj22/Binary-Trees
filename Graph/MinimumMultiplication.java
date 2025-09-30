package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplication {
    class Pair{
        int first;int second;
        Pair(int f,int s)
        {
            first=f;
            second=s;
        }
    }
     int minimumMultiplications(int[] arr,int start, int end)
    {
        Queue<Pair> q=new LinkedList<>();
        int dist[]=new int[100000];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
        q.add(new Pair(0,start));

        while(!q.isEmpty())
        {
            int steps=q.peek().first;
            int node=q.peek().second;
            q.poll();
            for(int i=0;i<arr.length;i++)
            {
                int element=(arr[i]*node)%100000;
                if(steps+1<dist[element])
                {
                    dist[element]=steps+1;
                    if(element==end) return steps+1;
                    q.add(new Pair(steps+1,element));
                }
            }
        }
        return -1;
    }
}
