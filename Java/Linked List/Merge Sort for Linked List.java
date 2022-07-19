class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
               // Base case
        if(head.next == null){
            return head;
        }
        
        Node h1 = head;
        // Finding the mid of the linked list
        Node m = findMid(head);
        Node h2 = m.next;
        m.next = null;
        
        // sorting two halves of linked lists
        h1 = mergeSort(h1);
        h2 = mergeSort(h2);

        return Merge(h1,h2); 
    }
    
    static Node findMid(Node head){
        Node fast = head.next;
        Node slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    static Node Merge(Node l1, Node l2){
        
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        Node res = new Node(0);
        Node t = res;
        
        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                t.next = l1;
                l1 = l1.next;
            }
            else{
                t.next = l2;
                l2 = l2.next;
            }
            t = t.next;
        }
            // if L1 is not null then add l2 to the result
            if(l1 != null) {
                t.next = l1;
                t = t.next;
            }
            // if L2 is not null then add l1 to the result
            if(l2 != null) {
                t.next = l2;
                t = t.next;
            }
        
        return res.next;
    }
}


