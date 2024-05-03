import java.util.*;
public class Main {
    public static void main(String[] args) {
        // test case 1
        int[][] test1 = {{0,1}};
        int numCourses = 2;
        int[] soln1 = findOrder(numCourses,test1);
        for(int i=0;i<soln1.length;i++){
            System.out.print(soln1[i] + " ");
        }
        System.out.println();
        // test case 2
        numCourses = 4;
        int[][] test2 = {{1,0},{2,0},{3,1},{3,2}};
        int[] soln2 = findOrder(numCourses,test2);
        for(int i=0;i<soln2.length;i++){
            System.out.print(soln2[i] + " ");
        }
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> prereqs = new HashMap<>();
        int[] cycle = new int[numCourses];
        int[] solution = new int[numCourses];
        int index=0,count=0;
        for(int[] course : prerequisites){
            int first = course[1],second = course[0];
            if (!prereqs.containsKey(first)){
                prereqs.put(first, new ArrayList());
            }
            prereqs.get(first).add(second);
            cycle[second]++;
        }
        Queue<Integer> visited = new LinkedList<>();
        for(int i=0;i < numCourses; i++){
            if(cycle[i]==0){visited.offer(i);}
        }
        while(!visited.isEmpty()){
            int current = visited.poll();
            solution[index++] = current;
            count++;
            for(int neighbor : prereqs.getOrDefault(current, new ArrayList<>()))
            {
                if(--cycle[neighbor]==0){ visited.offer(neighbor);}
            }
        }
        return count == numCourses ? solution : new int[0];
    }
}
