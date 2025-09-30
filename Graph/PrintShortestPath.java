package Graph;
import java.util.*;

public class PrintShortestPath {
    static class Pair {
        int node, weight; // clearer naming
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static ArrayList<Integer> path(int m, int n, int[][] graph) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // build adjacency list
        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(graph[i][0]).add(new Pair(graph[i][1], graph[i][2]));
            adj.get(graph[i][1]).add(new Pair(graph[i][0], graph[i][2]));
        }

        int dist[] = new int[m];
        int parent[] = new int[m];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) parent[i] = i;

        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.weight - y.weight);

        // source = 0 (or 1 depending on indexing)
        dist[0] = 0;
        q.add(new Pair(0, 0)); // (node=0, distance=0)

        while (!q.isEmpty()) {
            Pair top = q.poll();
            int node = top.node;
            int distance = top.weight;

            for (Pair e : adj.get(node)) {
                int adjNode = e.node;
                int edgeWeight = e.weight;

                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    parent[adjNode] = node;
                    q.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        // check if destination (m-1) is reachable
        if (dist[m - 1] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }

        // reconstruct path
        int node = m - 1;
        while (parent[node] != node) {
            ans.add(node);
            node = parent[node];
        }
        ans.add(0); // source
        Collections.reverse(ans);

        return ans;
    }
}
