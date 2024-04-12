public class Main {
    public static void main(String[] args) {
        System.out.println(power(2.00000,10));
        System.out.println(power(2.10000,3));
        System.out.println(power(2.00000,-2));
    }
    public static double power(double m, double n){
        double x = 1;
            while (n != 0) {
                if (n>0) {
                    x*=m;
                    n--;
               } else {
                    x*=(1/m);
                    n++;
               }
            }
        return x;
    }
}
