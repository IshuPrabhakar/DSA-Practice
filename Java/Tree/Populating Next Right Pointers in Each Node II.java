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
            return null;
        
        // Connect left node
        if(root.left != null)
            root.left.next = (root.right != null) ? root.right : findFirstNextNode(root);
        
        // Connect right node
        if(root.right != null)
            root.right.next = findFirstNextNode(root);
        
        connect(root.right);        
        connect(root.left);

        return root;
    }
    
    private Node findFirstNextNode(Node root){
        while(root.next != null){
            root = root.next;
            
            if(root.left != null)
                return root.left;
            
            if(root.right != null)
                return root.right;
        }
        
        return null;
    }
}
