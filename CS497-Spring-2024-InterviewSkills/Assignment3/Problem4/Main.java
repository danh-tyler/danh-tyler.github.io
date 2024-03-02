import java.util.*;
public class Main {
    public static void main(String[] args) {
        TreeNode f = new TreeNode(9);
        TreeNode e = new TreeNode(3);
        TreeNode d = new TreeNode(5);
        TreeNode c = new TreeNode(2,null,f);
        TreeNode b = new TreeNode(3,d,e);
        TreeNode a = new TreeNode(1,b,c);
        List<Integer> largest = largestValues(a);
        System.out.print(largest);

    }
    public static List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> soln = new ArrayList<Integer>();
        if (root == null){return soln;}
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int length=0,max=0;
        q.add(root);
        while (!q.isEmpty()){
            max = q.peek().val;
            length = q.size();
            for(int i=0;i<length;i++){
                TreeNode popped = q.remove();
                max = Math.max(max,popped.val);

                if (popped.left!=null){
                    q.add(popped.left);
                }
                if (popped.right!=null){
                    q.add(popped.right);
                }
            }
            soln.add(max);
        }
        return soln;
    }
}
