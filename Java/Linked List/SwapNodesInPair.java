/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        // Store the address of next node as it will be the new head of the swapped linked list
        ListNode newHead = head.next;
        
        // Store the address of the next of the 2nd node node which
        // is the pointer of the remaining node
        ListNode remainingNode = head.next.next;
        
        // Change the head to the second node, which essentialyy becamoe the head of swapped list
        head.next.next = head;
        
        // Now reverese the remaining nodes
        head.next = swapPairs(remainingNode);
        
        // Return the new head Node
        return newHead;
    }
}
