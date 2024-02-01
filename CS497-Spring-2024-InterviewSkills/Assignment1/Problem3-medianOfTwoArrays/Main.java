import java.util.ArrayList;
import java.util.*;


class Main {
    int[] nums1 = {1,3}, nums2 = {2}, nums3={1,2}, nums4={3,4};
    public static void main(String[] args){
        double case1,case2;
        Main myObj = new Main();
        case1 = myObj.findMedianSortedArrays(myObj.nums1, myObj.nums2);
        case2 = myObj.findMedianSortedArrays(myObj.nums3, myObj.nums4);
        System.out.println(case1);
        System.out.println(case2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isEven=false;
        int mid;
        double soln;
        if (nums1.length + nums2.length == 0){
            return 0;
        }
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        for (int i=0;i<nums1.length;i++){
            mergedList.add(nums1[i]);
        }
        for (int i=0;i<nums2.length;i++){
            mergedList.add(nums2[i]);
        }
        Collections.sort(mergedList);
        mid = mergedList.size()/2;
        if (mergedList.size()%2==0){
            isEven=true;
        }
        if (isEven){
            soln = (mergedList.get(mid-1) + mergedList.get(mid)) / 2.0;
        } else {
            soln = mergedList.get(mid);
        }
        return soln;
    }
}