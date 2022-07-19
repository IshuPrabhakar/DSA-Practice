class Clone {
    //Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // edge case
        if (head == null) return null;
        // step 1: clone the list
        Node temp = head;
        
        // step 1:  created new nodes and inserted in the org list
        while(temp != null){
            Node n = new Node(temp.data);
            n.next = temp.next;
            temp.next = n;
            temp = temp.next.next;
        }
        
        temp = head;
        
        // step 2: assigning the random pointers
        while(temp != null){
            if(temp.next != null)
            {
                temp.next.arb = (temp.arb != null)? temp.arb.next : null;
            }
            temp = temp.next.next;
        }
        
        temp = head;
        Node copy = head.next;
        Node clonelist = copy;
        
        // step 3: separating the clone and original list
        while(temp != null){
            temp.next = temp.next.next;
            if(copy.next != null)
                copy.next = copy.next.next;
            else
                copy.next = null;
            
            temp = temp.next;
            copy = copy.next;
        }
        
        return clonelist;
    }
}
