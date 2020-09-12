import sun.font.CreatedFontTracker;

import javax.xml.soap.Node;
import java.math.BigInteger;

public class P02_Add_Two_Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head.next;
    }

    private ListNode bigIntegerSolution(ListNode l1, ListNode l2) {
        BigInteger firstNum = getNodeNumber(l1);
        BigInteger secNum = getNodeNumber(l2);
        BigInteger sum = firstNum.add(secNum);
        ListNode result = buildListNodeFromNumber(sum);
        return result;
    }

    private BigInteger getNodeNumber(ListNode node) {
        StringBuilder num = new StringBuilder();
        while (node != null) {
            num.append(node.val);
            node = node.next;
        }
        return new BigInteger(num.reverse().toString());
    }

    private ListNode buildListNodeFromNumber(BigInteger num) {
        String invertedNum = new StringBuilder(String.valueOf(num)).reverse().toString();
        ListNode node = new ListNode(Character.getNumericValue(invertedNum.charAt(0)));
        ListNode tmp = node;
        for (int i = 1; i < invertedNum.length(); i++) {
            tmp.next = new ListNode(Character.getNumericValue(invertedNum.charAt(i)));
            tmp = tmp.next;
        }
        return node;
    }

    public static class ListNode {
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
