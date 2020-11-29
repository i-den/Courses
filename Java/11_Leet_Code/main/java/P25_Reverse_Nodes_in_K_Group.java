public class P25_Reverse_Nodes_in_K_Group {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode cur = head;
        int count = 0;

        while(count < k && cur != null) {
            count++;
            cur = cur.next;
        }

        if(count == k) {
            ListNode reverseHead = reverse(head, k);
            head.next = reverseKGroup(cur, k);
            return reverseHead;
        }
        return head;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;

        while(k > 0) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
            k--;
        }
        return prev;
    }


    ////////////////////////////////////////////////////////
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                pre = reverse2(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }


    private ListNode reverse2(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    ////////////////////////////////////////////////////////
    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        int cnt = 0;
        while (cnt < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }

        if (next != null) {
            head.next = reverseKGroup3(next, k);
        }

        return prev;
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
