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
    public ListNode mergeKLists(ListNode[] lists) {
        
        // intialising result node
        
        // creating the dummy node is the common technique
        // to avoid any edge cases
        ListNode res = new ListNode(0);
        
        for(ListNode list : lists){
            res.next = merge(res.next, list);
        }
        
        return res.next;
    }
    
    public ListNode merge(ListNode list1, ListNode list2){
        
        // if list1 is empty
        if(list1 == null) return list2;
        
        // if list2 is empty
        if(list2 == null) return list1;
        
        // intialising result node
        ListNode res = new ListNode(0);
        ListNode tail = res;
        
        // if you had solved previous merge two sorted linked list
        // then this is easy to understand
        
        // here loop will execute untill any of the list is not empty
        while(list1 != null && list2 != null){
            
            if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
            }
            else{
                tail.next = list2;
                list2 = list2.next;
            }
            // tail has to be incremented after every iteration
            // thats why it is kept outside of the if else statement
            tail = tail.next;
        }
        
        // if any of list becomes empty then append that list to the tail of the resaltant
        // list
        if(list1 == null) 
            tail.next = list2;
        else
            tail.next = list1;
        
        return res.next;
    }
}
