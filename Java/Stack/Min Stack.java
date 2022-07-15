class MinStack {

    public class Node{
        private int val;
        private int min;
        private Node next;
        
        Node(){}
        
        Node(int val, int min){
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }
    
    private Node head;
    
    public MinStack() {
    }
    
    public void push(int val) {
        if(head == null)
            head = new Node(val, Math.min(val, val));
        
        else {
            // do Concentrate on inserting node front of linkedlist
            Node tmp = new Node(val, Math.min(val, head.min));
            tmp.next = head;
            head = tmp;
        }
    }
    
    public void pop() {
        if(head != null)
            head = head.next;
    }
    
    public int top() {
        if(head != null)
            return head.val;
        return -1;
    }
    
    public int getMin() {
        if(head != null)
            return head.min;
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
