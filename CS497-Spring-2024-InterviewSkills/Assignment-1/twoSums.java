import java.util.Arrays;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] newArr = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int k=i+1;k<nums.length;k++){
                if (nums[i]+nums[k] == target){
                    newArr[0]=i;
                    newArr[1]=k;
                }
            }
        }
        return newArr;
    }
}

public class Main{
    public static void main(String[] args){
        int[] case1 = {2,7,11,15};
        int[] case2 = {3,2,4};
        int[] case3 = {3,3};
        int target = 6;
        int[] myarr = Solution.twoSum(case3,target);
        System.out.println(Arrays.toString(myarr));
    }
}