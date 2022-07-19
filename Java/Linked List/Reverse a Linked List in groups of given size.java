class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        int count = 0;
        Node temp = node;
        
        if(temp == null){
            return null;
        }
        
        // this is for reversing the list
        Node next = null, prev = null;
        while(count < k && temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            count++;
        }
        
        if(temp != null){
            node.next = reverse(next, k);
        }
        
        return prev;
    }
}
