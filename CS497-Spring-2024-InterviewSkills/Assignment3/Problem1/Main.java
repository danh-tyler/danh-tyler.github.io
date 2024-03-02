public class Main {
    public static void main(String[] args) {
        ListNode num1 = new ListNode(-10);
        ListNode num2 = new ListNode(-3);
        ListNode num3 = new ListNode(0);
        ListNode num4 = new ListNode(5);
        ListNode num5 = new ListNode(9);
        num1.next=num2;
        num2.next=num3;
        num3.next=num4;
        num4.next=num5;
        TreeNode root = sortedListToBST(num1);
        preOrderPrint(root);

    }
    public static TreeNode sortedListToBST(ListNode head) {
        if (head==null){ return null;}
        if (head.next==null){ return new TreeNode(head.val);}

        ListNode first = head;
        ListNode last = head.next.next;
        while (last!=null && last.next!=null){
            first=first.next;
            last=last.next.next;
        }
        ListNode middle = first.next.next;
        TreeNode root = new TreeNode(first.next.val);
        first.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle);
        return root;
    }

    public static void preOrderPrint(TreeNode root){
        if (root==null){ return;}
        preOrderPrint(root.left);
        System.out.print(root.val);
        System.out.print(" ");
        preOrderPrint(root.right);
    }
}
