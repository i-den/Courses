public class P203_Remove_Linked_List_Elements {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode();

        ListNode i = head;
        ListNode k = dummy;
        while(i != null) {
            if(i.val != val) {
                k.next = i;
                k = k.next;
            }
            i = i.next;
        }
        k.next = null;

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
