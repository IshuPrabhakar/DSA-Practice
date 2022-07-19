class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
         // Your code here
         HashSet <Integer> set = new HashSet<>();
         Node temp = head, prev = null;
         
         
         while(temp != null){
             if(set.contains(temp.data)){
                 prev.next = temp.next;
             }else{
                set.add(temp.data);
                prev = temp;
             }
            temp = temp.next;
         }

         return head;
    }
}
