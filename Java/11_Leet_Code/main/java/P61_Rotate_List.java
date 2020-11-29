import java.util.ArrayDeque;

public class P61_Rotate_List {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) {
            return head;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        while(head != null) {
            q.addLast(head.val);
            head = head.next;
        }

        int maxLen = k % q.size();
        for(int i = 0; i < maxLen; i++) {
            q.addFirst(q.removeLast());
        }

        ListNode ret = new ListNode();
        ListNode curr = ret;
        while(!q.isEmpty()) {
            curr.next = new ListNode(q.removeFirst());
            curr = curr.next;
        }
        return ret.next;
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
