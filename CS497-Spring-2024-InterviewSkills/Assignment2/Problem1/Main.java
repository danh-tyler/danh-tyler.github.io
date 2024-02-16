import java.util.Arrays;

public class Main
{
	public static void main(String[] args) {
		int[] nums1 = {3,2,3};
		int[] nums2 = {2,2,1,1,1,2,2};
		int maj1 = majorityElement(nums1);
		int maj2 = majorityElement(nums2);
		System.out.println(maj1);
		System.out.println(maj2);
	}
	public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int majElement = nums[0],currElement = nums[0],count=1,majCount=1;
        for (int i=1;i<nums.length;i++){
            if (currElement==nums[i]){
                count++;
            } else {
                if (count > majCount){
                    majElement = currElement;
                    majCount = count;
                    count = 1;
                }
                currElement = nums[i];
            }
        }
        if (count > majCount){
            majElement=currElement;
            majCount=count;
        }
        return majElement;
    }
}
