import java.util.HashSet;

public class P141_Linked_List_Cycle {

    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        HashSet<ListNode> visitedNodes = new HashSet<>();
        while(head != null) {
            if(visitedNodes.contains(head)) {
                return true;
            }
            visitedNodes.add(head);
            head = head.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
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
