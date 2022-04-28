package Java;

/**
 * AddTwoNumbers
 */
public class AddTwoNumbers {

    /**
     * Your input
     * [2,4,3]
     * [5,6,4]
     * Output
     * [7,0,1]
     * Expected
     * [7,0,8]
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode addition = new ListNode(0);
        ListNode head = addition;

        int carry = 0, last_digit = 0;
        while (l1 != null || l2 != null) {
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;

            int sum = a + b + carry;
            carry = sum / 10;
            last_digit = sum % 10;
            ListNode temp = new ListNode(last_digit);
            head.next = temp;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            head = head.next;
        }
        if (carry > 0) {
            ListNode n = new ListNode(carry);
            head.next = n;
            head = head.next;
        }
        return addition.next;
    }
}

class ListNode {
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