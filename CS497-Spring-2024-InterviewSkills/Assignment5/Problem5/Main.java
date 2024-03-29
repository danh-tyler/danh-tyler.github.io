import java.util.*;
public class Main {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<Integer>();
        int level = 1;
        for (int i=1; i<=n;i++){
            list.add(level);
            if (level*10 <= n){
                level*=10;
            } else {
                while (level%10==9 || level+1 > n){
                    level /= 10;
                }
                level++;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        List<Integer> list = lexicalOrder(13);
        System.out.println(list);
        list = lexicalOrder(105);
        System.out.println(list);
    }
}
