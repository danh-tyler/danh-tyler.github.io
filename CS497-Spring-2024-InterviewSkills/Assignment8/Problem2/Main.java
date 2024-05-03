public class Main {
    public static void main(String[] args) {
        // test case 1
        int dividend = 10,divisor=3;
        System.out.println(divide(dividend,divisor));
        // test case 2
        dividend = 7;
        divisor=-3;
        System.out.println(divide(dividend,divisor));
    }
    public static int divide(int dividend, int divisor) {
        boolean isNegative = false;
        int result=0;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){ isNegative=true;}
        int current = dividend;
        while(current >= Math.abs(divisor)){
            result++;
            current-=Math.abs(divisor);
        }
        if (isNegative){ result = result - (2*result);}
        return result;
    }
}
