import java.util.*;
public class Main {
    public static void main(String[] args) {
        //test case 1
        int numCourses = 2;
        int[][] pre1 = {{1,0}};
        System.out.println(canFinish(numCourses,pre1));
        // test case 2
        numCourses = 2;
        int[][] pre2 = {{1,0},{0,1}};
        System.out.println(canFinish(numCourses,pre2));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> preReqList = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        //Initialize hash map to empty lists
        for (int i=0;i<numCourses;i++){
            preReqList.put(i,new ArrayList<Integer>());
        }
        // Fill adjacency list with courses into hashmap
        for(int i=0;i<prerequisites.length;i++){
            preReqList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        // call dfs to search through graph to see if there are any loops
        for (int i=0; i<numCourses;i++){
            if(!dfs(i,visited,preReqList)){return false;}
        }
        return true;
    }
    public static boolean dfs(int course, HashSet<Integer> visited,HashMap<Integer,ArrayList<Integer>> preReqList){
        // if course has been visited already, return false. loop exists
        if (visited.contains(course)){
            return false;
        }
        // if current course has empty list in hash map, return true can complete
        if (preReqList.get(course).isEmpty()){
            return true;
        }

        // add current course to visited
        visited.add(course);

        // recursively call dfs for every course in the adjacency list for that course
        for (int i=0;i<preReqList.get(course).size();i++){
            if (!dfs(preReqList.get(course).get(i),visited,preReqList)){ return false;}
        }
        // done visiting, remove course
        visited.remove(course);
        // clear the course to indicate already checked
        preReqList.get(course).clear();
        return true;
    }
}
