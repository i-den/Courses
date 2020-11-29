public class P21_Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode head = new ListNode();
        ListNode curr = head;

        while (left != null && right != null) {
            if (left.val == right.val) {
                ListNode leftTmp = left.next;

                left.next = right;
                curr.next = left;
                curr = right;

                left = leftTmp;
                right = right.next;
            } else if (left.val < right.val) {
                curr.next = left;
                curr = left;
                left = left.next;
            } else {
                curr.next = right;
                curr = right;
                right = right.next;
            }
        }

        if (left != null) {
            curr.next = left;
        }
        if (right != null) {
            curr.next = right;
        }

        return head.next;
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
