class Solution{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        
        Node temp2 = head;
        for(int i=1; i < k;i++){
            temp2 = temp2.next;
        }
        
        head = temp2.next;
        temp2.next = null;
        return head;
    }
}
