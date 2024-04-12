import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[][] graphs1 = {{1,2},{3},{3},{}};
        int[][] graphs2 = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> myList= allPathsSourceTarget(graphs1);
        System.out.println(myList);
        myList = allPathsSourceTarget(graphs2);
        System.out.println(myList);
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> soln = new ArrayList<>();
        Queue<List<Integer>> paths = new LinkedList<>();
        paths.add(Arrays.asList(0));
        int goal = graph.length-1;
        while (!paths.isEmpty()){
            List<Integer> currPath = paths.poll();
            int last = currPath.get(currPath.size()-1);
            if (last == goal){
                soln.add(new ArrayList<>(currPath));
            } else {
                int[] neigh = graph[last];
                for (int n : neigh){
                    List<Integer> list = new ArrayList<>(currPath);
                    list.add(n);
                    paths.add(list);
                }
            }
        }
        return soln;
    }
}
