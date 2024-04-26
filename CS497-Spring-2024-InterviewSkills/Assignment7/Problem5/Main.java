import java.util.*;
public class Main {
    public static void main(String[] args) {
        // test case 1
        int[] test1 = {-2,1,-3,4,-1,2,1,-5,4};
        // test case 2
        int[] test2 = {4,-1,2,1};
        // test case 3
        int[] test3 = {1};
        System.out.println(maxSubArray(test1));
        System.out.println(maxSubArray(test2));
        System.out.println(maxSubArray(test3));
    }
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum=0;
        for (int n : nums){
            if (currSum < 0){
                currSum=0;
            }
            currSum+=n;
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
