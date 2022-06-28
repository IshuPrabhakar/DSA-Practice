public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode addition = new ListNode(0);
        ListNode head = addition;
      
        // The best thing is that numbers represented by the linkedlist re in reversed order
        // that means it will be easy for us to add a number from the end of the linked list as we
        // always add numbers starting form the left side and in the linked list it is defficult to to that
        // we have to reverse the linked list.
      
        // In this approch we essentially extract the numbers represented by the linked list and add them
        // if we get a carry then store it in the another variable and it with the next digit
        // repeat the process untill the addition is not completed

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
