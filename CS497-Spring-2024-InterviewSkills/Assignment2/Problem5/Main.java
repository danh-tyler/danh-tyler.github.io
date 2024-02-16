class Main {

    public static void main(String[] args){
        int[] nums = {2,-1,2};
        int[] t = {1};
        int n = shortestSubarray(nums,3);
        int x = shortestSubarray(t,1);
        System.out.println(n);
        System.out.println(x);
    }

    public static int shortestSubarray(int[] nums, int k) {
        int currSum=0,shortest=1000;
        if (nums.length<1){ return shortest; 
        } else if (nums.length==1){
            if (nums[0]==k){ return 1; }
        }
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if (currSum+nums[j]<k){
                    currSum+=nums[j];
                } else {
                    currSum+=nums[j];
                    if (j-i+1 < shortest){
                        shortest = j-i+1;
                    }
                }
            }
            currSum=0;
        }
        if (shortest==1000){ return -1;}
        return shortest;
    }
}
