import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,2,3,6,8,8,9};
        List<Integer> list = findClosestElements(arr,5,9);
        System.out.println(list);
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left=0,right=left+k,indexL=left,indexR=right,lowest=Integer.MAX_VALUE;
        int[] diff = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            diff[i] = Math.abs(arr[i]-x);
        }
        while (right!=arr.length+1){
            int curr = 0;
            for (int i=left;i<right;i++){
                curr+=diff[i];
            }
            if (curr < lowest){
                indexL = left;
                indexR = right;
                lowest = curr;
            }
            left++;
            right++;
        }
        List<Integer> soln = new ArrayList<>();
        for(int i = indexL; i<indexR;i++){
            soln.add(arr[i]);
        }
        return soln;
    }
}
