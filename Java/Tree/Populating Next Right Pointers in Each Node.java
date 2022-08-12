/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null)
            return root;
            
        Node currNode = root, nextNode = root.left;
        
        // Standerd BFS Solution with O(1) soace compelxity
        // No need to use Queue although we can use Queue as it will easy to understand
        
        while(currNode != null && nextNode != null) {
            // connect currents left to currents right
            currNode.left.next = currNode.right;
            
            if(currNode.next != null)
                currNode.right.next = currNode.next.left;
            
            // move currnode level wise left to right
            currNode = currNode.next;
            
            // !(currNode != null) this means if currNode is null and it has connected all
            // the nodes now it is reached at the end of curr level then it has to move
            // to the next level i.e currNode = nextNode
            if(!(currNode != null)){
                currNode = nextNode; // nextNode is basically to keep reference to the next levels first node
                nextNode = currNode.left;
            }
        }
        
        return root;
    }
}
