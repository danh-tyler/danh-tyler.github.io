import java.util.*;

class Main {

    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4};
        int k = 2,kthLargest=0;
        kthLargest = findKthLargest(nums,k);
        System.out.println(kthLargest);

    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int kth, top;
        // add to heap of size k
        for (int i = 0; i < k; i++) {
            q.add(nums[i]);
        }

        for (int j = k; j < nums.length; j++) {
            top = q.peek();
            if (nums[j] > top) {
                q.poll();
                q.add(nums[j]);
            }
        }
        kth = q.peek();
        return kth;
    }
}
