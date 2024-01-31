import java.util.Arrays;
class Main{
    int[] case1 = {5,7,7,8,8,10},case2={},case3={1},case4={2,2};
    public static void main(String args[]){
        Main myObj = new Main();
        int target1 = 8, target2 = 6, target3 = 0, target4 = 1, target5 = 2;
        int[] arr1 = Main.searchRange(myObj.case1,target1);
        int[] arr2 = Main.searchRange(myObj.case1,target2);
        int[] arr3 = Main.searchRange(myObj.case2,target3);
        int[] arr4 = Main.searchRange(myObj.case3,target4);
        int[] arr5 = Main.searchRange(myObj.case4,target5);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));
    }
    public static int[] searchRange(int[] nums,int target){
        int mid = nums.length / 2,first=-1,last=-1,start;
        boolean foundFlag=false;
        int[] soln = {first,last};
        if (nums.length<1){ return soln;}
        if (target < nums[mid]){ start=0;
        } else{ start = mid;}
        while (start>0 && nums[start]==target){
            if(target==nums[start-1]){start--;
            } else{
                break;}
        }
        for (int i=start;i<nums.length;i++){
            if (nums[i]==target && foundFlag==false){
                foundFlag=true;
                first=i;
                last=i;
            } else if (nums[i]==target){
                last=i;
            }
        }
        soln[0]=first;
        soln[1]=last;
        return soln;
    }
}