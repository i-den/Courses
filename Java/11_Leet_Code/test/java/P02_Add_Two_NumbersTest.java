import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P02_Add_Two_NumbersTest {



    P02_Add_Two_Numbers solution;

    @BeforeEach
    void setUp() {
        solution = new P02_Add_Two_Numbers();
    }


    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            P02_Add_Two_Numbers.ListNode firstNode = new P02_Add_Two_Numbers.ListNode(2);
            P02_Add_Two_Numbers.ListNode node1_2 = new P02_Add_Two_Numbers.ListNode(4);
            P02_Add_Two_Numbers.ListNode node1_3 = new P02_Add_Two_Numbers.ListNode(3);

            P02_Add_Two_Numbers.ListNode secNode = new P02_Add_Two_Numbers.ListNode(5);
            P02_Add_Two_Numbers.ListNode node2_2 = new P02_Add_Two_Numbers.ListNode(6);
            P02_Add_Two_Numbers.ListNode node2_3 = new P02_Add_Two_Numbers.ListNode(4);

            P02_Add_Two_Numbers.ListNode expected = new P02_Add_Two_Numbers.ListNode(7);
            P02_Add_Two_Numbers.ListNode expected_2 = new P02_Add_Two_Numbers.ListNode(0);
            P02_Add_Two_Numbers.ListNode expected_3 = new P02_Add_Two_Numbers.ListNode(8);

            firstNode.next = node1_2;
            node1_2.next = node1_3;

            secNode.next = node2_2;
            node2_2.next = node2_3;

            expected.next = expected_2;
            expected_2.next = expected_3;

            P02_Add_Two_Numbers.ListNode result = solution.addTwoNumbers(firstNode, secNode);

            assertTrue(nodesContainSameElements(result, expected));
        }
    }

    private boolean nodesContainSameElements(P02_Add_Two_Numbers.ListNode result, P02_Add_Two_Numbers.ListNode expected) {
        try {
            while (expected.next != null) {
                if (result.val != expected.val) {
                    return false;
                }
                result = result.next;
                expected = expected.next;
            }
            return true;
        } catch (Exception e) { // handles incorrect result lengths
            return false;
        }
    }
}