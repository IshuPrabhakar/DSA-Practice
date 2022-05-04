package Java;

/**
 * AddTwoNumbers
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode addition = new ListNode(0);
        ListNode head = addition;

        int carry = 0, last_digit = 0;
        while (l1 != null || l2 != null || carry > 0) {
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