import java.util.Arrays;
public class Main{
    int[] case1 = {2,7,11,15};
    int[] case2 = {3,2,4};
    int[] case3 = {3,3};
    public static void main(String[] args){
        Main myObj = new Main();
        int target1 = 9, target2 = 6;
        int[] arr1 = Main.twoSums(myObj.case1,target1);
        int[] arr2 = Main.twoSums(myObj.case2,target2);
        int[] arr3 = Main.twoSums(myObj.case3,target2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
    public static int[] twoSums(int[] nums, int target) {
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