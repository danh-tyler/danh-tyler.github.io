import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3,null,n4);
        TreeNode n2 = new TreeNode(2,null,n3);
        TreeNode n1 = new TreeNode(1,null,n2);
        TreeNode newTree = balanceBST(n1);
        preOrderPrint(newTree);
    }
    public static TreeNode balanceBST(TreeNode root) {
        if (root==null){ return null;}
        ArrayList<Integer> ascending = new ArrayList<Integer>();
        traverseTree(root,ascending,0);
        return balanceBSTHelper(ascending,ascending.size()-1,0);
    }
    public static void traverseTree(TreeNode root, ArrayList<Integer> ascending, int index){
        if (root==null){return;}
        index++;
        traverseTree(root.left,ascending,index);
        ascending.add(root.val);
        traverseTree(root.right,ascending,index);
    }
    public static TreeNode balanceBSTHelper(ArrayList<Integer> ascending,int length, int start){
        if (start>length){return null;}
        int mid = start+(length-start)/2;
        TreeNode node = new TreeNode(ascending.get(mid));
        node.left=balanceBSTHelper(ascending,mid-1,start);
        node.right=balanceBSTHelper(ascending,length,mid+1);
        return node;
    }
    public static void preOrderPrint(TreeNode root){
        if (root==null){ return;}
        preOrderPrint(root.left);
        System.out.print(root.val);
        System.out.print(" ");
        preOrderPrint(root.right);
    }
}
