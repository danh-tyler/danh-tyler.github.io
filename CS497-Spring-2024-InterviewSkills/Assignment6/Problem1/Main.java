import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{1,2},{2,0}};
        int[][] edges2 = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(validPath(3,edges1,0,2));
        System.out.println(validPath(6,edges2,0,5));
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination){ return true;}
        // Creates adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<Integer>());
        }

        // Fill adjacency list with edges
        for (int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        // visited list
        ArrayList<Integer> visited = new ArrayList<>();
        // queue to add neighbors
        Queue<Integer> q = new LinkedList<>();
        visited.add(source);
        q.add(source);
        // if queue is not empty, keep processing queue
        while (!q.isEmpty()){
            int curr = q.poll();
            for (int edge : adjList.get(curr)){
                if (!visited.contains(edge)){
                    visited.add(edge);
                    q.add(edge);
                }
            }
        }
        return visited.contains(destination);
    }
}
