class Main{
    public static void main(String[] args){
        ListNode num1 = new ListNode(1);
        ListNode num2 = new ListNode(2);
        ListNode num3 = new ListNode(4);
        num1.next = num2;
        num2.next = num3;
        ListNode num4 = new ListNode(1);
        ListNode num5 = new ListNode(3);
        ListNode num6 = new ListNode(4);
        num4.next = num5;
        num5.next = num6;
        //ListNode merge = mergeTwoLists(num1,num4);
        //while (merge!=null){
        //    System.out.print(merge.val);
        //    merge = merge.next;
        //}
        System.out.println();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(6);
        n4.next = n5;

        ListNode[] lists = {n1,num4,n4};
        ListNode[] l2 = {new ListNode(2),new ListNode(-1),null};

        ListNode mergeK = mergeKLists(lists);
        System.out.print("Merged List: ");
        while (mergeK != null){
            System.out.print(mergeK.val);
            mergeK = mergeK.next;
        }
        System.out.println();
        ListNode mergeL = mergeKLists(l2);
        System.out.print("Merged List: ");
        while (mergeL!=null){
            System.out.print(mergeL.val);
            mergeL=mergeL.next;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){ return null; }
        ListNode temp = new ListNode(0);
        ListNode mergedList = temp;
        while(lists[0]!=null){
            temp.next = new ListNode(lists[0].val);
            lists[0] = lists[0].next;
            temp=temp.next;
        }
        for (int i=1;i<lists.length;i++){
            mergedList.next = mergeTwoLists(mergedList.next,lists[i]);
        }
            return mergedList.next;
    }
    public static ListNode mergeTwoLists(ListNode nums1, ListNode nums2) {
        ListNode temp = new ListNode(0);
        ListNode it = temp;
        while (nums1!=null && nums2!=null){
            if (nums1.val < nums2.val){
                temp.next = new ListNode(nums1.val);
                nums1=nums1.next;
            } else{
                temp.next = new ListNode(nums2.val);
                nums2=nums2.next;
            }
            temp=temp.next;
        }
        while (nums1!=null){
            temp.next = new ListNode(nums1.val);
            nums1=nums1.next;
            temp=temp.next;
        }
        while (nums2!=null){
            temp.next = new ListNode(nums2.val);
            nums2=nums2.next;
            temp=temp.next;
        }
        temp = it.next;
        while(temp!=null){
            System.out.print(temp.val);
            temp=temp.next;
        }
        System.out.println();
        return it.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}