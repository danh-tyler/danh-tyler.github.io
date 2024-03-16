import java.util.*;
class Solution {
    public static void (String[] args){
        int[] nums = {1,2,3,5};
        int[] soln = new int[2];
        soln = kthSmallestPrimeFraction(nums,3);
        System.out.print(soln[0]);
        System.out.print(soln[1]);
    }
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int length = arr.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>();
        for (int i=0;i<length-1;i++){
            for (int j=i+1; j<length;j++){
                queue.offer(new int[] {arr[i],arr[j]});
            }
        }
        for (int i=0;i<k;i++){
            queue.poll();
        }
        return queue.poll();
    }
}
