public class P19_Remove_Nth_Node_From_End_of_List {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        ListNode curr = dummy;
        while (fast != null) {
            fast = fast.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
