import java.util.*;
public class Main {
    public static void main(String[] args) {
        //test case 1
        int[][] times = {{1,2,1}};
        int n=2,k=1;
        System.out.println(networkDelayTime(times,n,k));
        //test case 2
        n=2;
        k=2;
        System.out.println(networkDelayTime(times,n,k));
        // test case 3
        n=4;
        int[][] times2 = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(times2,n,k));
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        // hashmap of edges
        HashMap<Integer,List<int[]>> adj = new HashMap<>();
        // initialize adjacency list with empty lists
        for (int[] edge : times){
            int source = edge[0],target=edge[1], weight=edge[2];
            adj.putIfAbsent(source,new ArrayList<>());
            adj.get(source).add(new int[]{target,weight});
        }
        int travel[] = new int[n+1];
        Arrays.fill(travel,Integer.MAX_VALUE);

        travel[k]=0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        minHeap.add(new int[]{k,0});

        while(!minHeap.isEmpty()){
            int[] nodes = minHeap.poll();
            int sourceNode = nodes[0],time=nodes[1];

            if (time > travel[sourceNode]){ continue; }
            List<int[]> touching = adj.getOrDefault(sourceNode, new ArrayList<>());
            for(int[] edgeNodes:touching){
                int targetNode = edgeNodes[0],weight = edgeNodes[1];
                if(time+weight < travel[targetNode]){
                    travel[targetNode]=time+weight;
                    minHeap.offer(new int[] {targetNode, travel[targetNode]});
                }
            }
        }
        for (int i=1;i<=n;i++){
            if (travel[i] == Integer.MAX_VALUE){ return -1;}
        }
        int max=-1;
        for(int i=1;i<=n;i++){
            max = Math.max(max,travel[i]);
        }
        return max;
    }
}
