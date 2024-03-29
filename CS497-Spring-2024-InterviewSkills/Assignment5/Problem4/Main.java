public class Main {
    public static void main(String[] args) {
        TreeNode num3 = new TreeNode(15);
        TreeNode num4 = new TreeNode(7);
        TreeNode num2 = new TreeNode(20,num3,num4);
        TreeNode num1 = new TreeNode(9);
        TreeNode root = new TreeNode(-10,num1,num2);

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode root2 = new TreeNode(1,n1,n2);
        System.out.println(maxPathSum(root));
        System.out.println(maxPathSum(root2));
    }
        public static int maxPathSum(TreeNode root) {
            int[] max = new int[1];
            search(root,max);
            return max[0];
        }
        public static int search (TreeNode root, int[] max){
            if (root==null){return 0;}
            int leftVal,rightVal;
            leftVal = search(root.left,max);
            leftVal = Math.max(0,leftVal);
            rightVal = search(root.right,max);
            rightVal = Math.max(0,rightVal);
            max[0]=Math.max(max[0],leftVal+rightVal+root.val);
            return Math.max(leftVal,rightVal) + root.val;
        }
}
