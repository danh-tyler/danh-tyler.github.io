class Main {
    public static void main(String[] args){
        int target = 2;
        ListNode num1 = new ListNode(1);
        ListNode num2 = new ListNode(2);
        ListNode num3 = new ListNode(3);
        ListNode num4 = new ListNode(4);
        ListNode num5 = new ListNode(5);
        num1.next=num2;
        num2.next=num3;
        num3.next=num4;
        num4.next=num5;
        ListNode temp = num1;
        ListNode head = num1;
        while (temp!=null){
            System.out.print(temp.val);
            System.out.print(" ");
            temp=temp.next;
        }
        System.out.print("\n");
        ListNode soln = removeNthFromEnd(head,target);
        temp = num1;
        while (temp!=null){
            System.out.print(temp.val);
            System.out.print(" ");
            temp=temp.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0,head);
        ListNode first = temp;
        ListNode last = head;

        if (head == null){
            return null;
        }
        while(n > 0 && last!=null){
            last = last.next;
            n--;
        }
        while(last!=null){
            first=first.next;
            last=last.next;
        }
        first.next = first.next.next;
        return temp.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}