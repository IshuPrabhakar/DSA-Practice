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
    // left is the starting of the reordered list
    // to be accesible to all it is made global variable
    ListNode left;
    
    public void reorderList(ListNode head) {
        // Assinging the head pointer to the left pointer
        // as it will be the first node int the list which remains the same
        // after reorder
        left = head;
        reachEnd(head);
    }
    
    public void reachEnd(ListNode right){
        
        // Base case for recursive call
        if(right == null)
            return;
        
        // recursive call
        reachEnd(right.next);
        
        //
         if(left == null)
            return;
        
        // After the recursive call control starts to go from last node or last function call
        // Now starting from the last node after the last fuction call we get pointer of last
        // Node which has to be inserted in the second place in the reordered list
        
        // Since left points to the first node
        // we will insert the last node to the next of the first node
         if (left != right && left.next != right) {
            ListNode temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        }
        // After completion of this if part there will be a loop created
        else{
             // At this left will points to the last node after the completion of if part
             // If length is even left will point to second last node then set next.next = null 
            if(left.next == right){
                left.next.next = null;
                left = null;
            }
            else{ // yhis for odd case
                left.next = null;
                left = null;
            }
        }
        
    }
}
