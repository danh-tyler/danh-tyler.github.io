import java.util.*;
public class Main {
    public static void main(String[] args) {
        // test case 1
        String s = "(()";
        System.out.println(longestValidParentheses(s));
        // test case 2
        s = ")()())";
        System.out.println(longestValidParentheses(s));
        // test case 3
        s = "";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        int left = 0, right = 0;
        int maxLength=0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c == '('){ left++;
            } else { right++;}
            if (left==right){
                int length = left+right;
                maxLength = Math.max(maxLength,length);
            } else if (right > left){
                left = right = 0;
            }
        }
        // reverse direction
        left = right = 0;
        for (int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if (c == '('){ left++;
            } else { right++;}
            if (left == right){
                int length = left+right;
                maxLength = Math.max(maxLength,length);
            } else if (left > right){
                left = right = 0;
            }
        }
        return maxLength;
    }
}
