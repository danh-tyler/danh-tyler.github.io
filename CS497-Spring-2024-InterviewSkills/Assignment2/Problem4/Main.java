import java.util.Arrays;
import java.util.Stack;

class Main {

    public static void main(String[] args){
        String s = "cbacdcbc";
        String x = "bcabc";
        String t = removeDuplicateLetters(s);
        System.out.println(t);
        System.out.println(x);
        }

    public static String removeDuplicateLetters(String s) {
        int[] frequency = new int[26]; // keep track of frequency of letters
        String newStr="",revStr="";
        for(int i=0;i<s.length();i++){ // fill frequency array
            frequency[s.charAt(i)-'a']++;
        }
        Stack<Character> myStack = new Stack<Character>();
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, false); // fill visited array and initalize all to false

        for (int i=0;i<s.length();i++){ // iterate through string
            if (visited[s.charAt(i)-'a']){ // if already visited, decrement frequency
                frequency[s.charAt(i)-'a']--;
            } else { // if not visited, proceed
                /*if stack is not empty AND the top is bigger than the current character in the string
                AND there exists another instance later in the string, clear the stack and revert visited array */
                while(!myStack.empty() && myStack.peek()>s.charAt(i) && frequency[myStack.peek()-'a']>0){
                    visited[myStack.peek()-'a']=false;
                    myStack.pop();
                }
                myStack.push(s.charAt(i)); // push value onto stack
                visited[s.charAt(i)-'a']=true; // change visited to true to indicate already exists in stack
                frequency[s.charAt(i)-'a']--; // decrement frequency
            }
        }
        while(!myStack.empty()){ // pop stack into string
            revStr+=myStack.pop();
        }
        for(int i=revStr.length()-1;i>=0;i--){ // reverse string
            newStr+=revStr.charAt(i);
        }
        return newStr;
    }
}
