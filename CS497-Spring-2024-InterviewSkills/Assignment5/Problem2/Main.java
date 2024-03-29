public class Main {
    static int min = Integer.MAX_VALUE;
    static Integer prev = null;
    public static int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        getMinimumDifference(root.left);
        if (prev != null){
            min = Math.min(min,Math.abs(root.val - prev));
        }
        if (root!=null){
            prev = root.val;
        }
        getMinimumDifference(root.right);
        return min;
    }
    public static void main(String[] args) {
        TreeNode num5 = new TreeNode(3);
        TreeNode num4 = new TreeNode(1);
        TreeNode num3 = new TreeNode(6);
        TreeNode num2 = new TreeNode(2,num4,num5);
        TreeNode root = new TreeNode (4,num2,num3);
        int x = getMinimumDifference(root);

        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3,p1,null);
        TreeNode root1 = new TreeNode(1,null,p2);
        System.out.println(x);
        int y = getMinimumDifference(root1);
        System.out.println(y);
    }
}
