import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder,inorder);
        preOrderPrint(root);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        int[] index = {0};
        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
                visited.put(inorder[i], i);
        }
        TreeNode root = buildTreeHelper(preorder, inorder, index, visited, 0, length - 1);
        return root;
    }
    public static void preOrderPrint(TreeNode root){
        if (root==null){ return;}
        preOrderPrint(root.left);
        System.out.print(root.val);
        System.out.print(" ");
        preOrderPrint(root.right);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int[] index, HashMap<Integer, Integer> visited, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index[0]]);
        int mid = visited.get(preorder[index[0]++]);
        node.left = buildTreeHelper(preorder, inorder, index, visited, start, mid - 1);
        node.right = buildTreeHelper(preorder, inorder, index, visited, mid + 1, end);
        return node;
    }
}
