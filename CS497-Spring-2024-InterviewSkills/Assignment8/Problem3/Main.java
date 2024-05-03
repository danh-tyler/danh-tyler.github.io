import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // test case 1
        int[] coins1 = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins1,amount));
        // test case 2
        int[] coins2 = {2};
        amount = 3;
        System.out.println(coinChange(coins2,amount));
        // test case 3
        int[] coins3 = {1};
        amount = 0;
        System.out.println(coinChange(coins3,amount));
    }
    public static int coinChange(int[] coins, int amount) {
        if (amount==0){return 0;}
        Arrays.sort(coins);
        if (amount < coins[0]){return -1;}
        int result=0;
        for(int i=coins.length - 1;i>=0;i--){
            while(amount >= coins[i]){
                amount-=coins[i];
                result++;
            }
        }
        return amount==0?result:-1;
    }
}
