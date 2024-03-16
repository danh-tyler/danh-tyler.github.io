import java.util.*;
class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] x = topKFrequent(nums,2);
        System.out.println(x);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length==1){
            int[] x = {nums[0]};
            return x;
        }
        List<Integer>[] freq = new List[nums.length+1];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ArrayList<Integer> soln = new ArrayList<Integer>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        for (int n : map.keySet()){
            int count = map.get(n);
            if (freq[count]==null){
                freq[count] = new ArrayList<Integer>();
            }
            freq[count].add(n);
        }
        int[] arr = new int[k];
        for(int i = freq.length-1;i>=0;i--){
            if (freq[i]!=null){
                soln.addAll(freq[i]);
                k--;
                if(k<0){
                    break;
                }
            }
        }
        for (int i=0; i<soln.size()-1;i++){
            arr[i] = soln.get(i);
        }
        return arr;
    }
}
