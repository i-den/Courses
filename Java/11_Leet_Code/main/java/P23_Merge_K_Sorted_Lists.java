import java.util.PriorityQueue;

public class P23_Merge_K_Sorted_Lists {

    public ListNode mergeKListsAccumulate(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }

        ListNode curr = lists[0];
        for(int i = 1; i < lists.length; i++) {
            curr = mergeLists(curr, lists[i]);
            lists[i] = null;
        }

        return curr;
    }

    private ListNode mergeLists(ListNode left, ListNode right) {
        ListNode head = new ListNode();
        ListNode curr = head;

        while(left != null && right != null) {
            if(left.val < right.val) {
                curr.next = left;
                curr = curr.next;
                left = left.next;
            } else if (left.val > right.val) {
                curr.next = right;
                curr = curr.next;
                right = right.next;
            } else {
                ListNode tmp = left.next;
                curr.next = left;
                left.next = right;
                curr = right;
                left = tmp;
                right = right.next;
            }
        }

        if(left != null) {
            curr.next = left;
        }
        if(right != null) {
            curr.next = right;
        }

        return head.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (ListNode node : lists) {
            while (node != null) {
                heap.add(node.val);
                node = node.next;
            }
        }

        ListNode curr = head;
        while (!heap.isEmpty()) {
            curr.next = new ListNode(heap.remove());
            curr = curr.next;
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
