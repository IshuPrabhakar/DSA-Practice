class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
	    // Don't know why it always at test case no 108 gives TLE error
	    // regardless of any approch is used;
         Node temp1 = head1;
         Node temp2 = head2;
         int L1 = 0,L2 = 0;
         
         while(temp1 != null || temp2 != null){
             if(temp1 != null) {
                temp1 = temp1.next;
                L1++;
             }
             
             if(temp2 != null) {
                temp2 = temp2.next;
                L2++;
             }
         }
         temp1 = head1;
         temp2 = head2;
         
         if(L1>L2){
            int skip = L1-L2;
            for(int i = 1; i<=skip;i++){
                 temp1 = temp1.next;
             }
         }else{
            int skip = L2-L1;
            for(int i = 1; i<=skip;i++){
                 temp2 = temp2.next;
             }
         }
         
         while(temp1 != temp2){
             temp1 = temp1.next;
             temp2 = temp2.next;
             
             if(temp1 == temp2) return temp1.data;
         }
         
         return -1;
	}
}
