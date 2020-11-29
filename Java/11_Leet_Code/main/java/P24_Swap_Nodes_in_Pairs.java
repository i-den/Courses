public class P24_Swap_Nodes_in_Pairs {

    public ListNode swapPairs(ListNode head) {
        ListNode parent = head;
        ListNode child;
        ListNode grand = null;

        while (parent != null && parent.next != null) {
            child = parent.next;
            parent.next = child.next;
            if (parent == head) {
                head = child;
            }
            child.next = parent;
            if (grand != null) {
                grand.next = child;
            }
            grand = parent;
            parent = parent.next;
        }
        return head;
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
