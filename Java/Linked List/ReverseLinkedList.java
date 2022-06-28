class Solution {
  
  public ListNode reverse(ListNode head){
        
        if(head == null || head.next == null)
            return head;
        // Store the address of the last node
        ListNode Lastnode = reverse(head.next);
        
        // as the 2nd last node function call ends and its return value is the lastnode
        // now the current head which is 2nd last node set its next.next which is the next
        // of the lastnode to the head
        // because the current head will become 2nd node in the reversed list 
        head.next.next = head;
        
        // Now set the current nodes next to null
        head.next = null;
        
        // return the last node which is the 1st node of the reversed linked list
        return Lastnode;
    }
  
}
