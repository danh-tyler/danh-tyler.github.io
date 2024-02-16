import java.util.Arrays;

class Main {

    public static void main(String[] args){
        int[] nums1 = {3,6,9,1};
        int[] nums2 = {100,3,2,1};
        int[] nums3 = {10};
        int maxGap1 = maximumGap(nums1);
        int maxGap2 = maximumGap(nums2);
        int maxGap3 = maximumGap(nums3);
        System.out.println("MaxGap1: " + maxGap1);
        System.out.println("MaxGap2 " + maxGap2);
        System.out.println("MaxGap3: " + maxGap3);
    }

    public static int maximumGap(int[] nums) {
        int currMax=0;
        Arrays.sort(nums);
        if (nums.length < 2){
            return currMax;
        }
        for (int i=1;i<nums.length;i++){
            int j = i-1;
            if (nums[i]-nums[j] > currMax){
                currMax = nums[i]-nums[j];
            }
        }
        return currMax;
    }
}
