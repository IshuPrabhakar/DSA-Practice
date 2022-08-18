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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private ListNode Head;
    public TreeNode sortedListToBST(ListNode head) {
        
        Head = head;
        // There can be many approches to solve this
        // Approach 1: Convert list to sorted array and then solve it, TC => O(N), SC => O(N)
        // Approach 2: Solve directly using inorder travesal. TC => O(N), SC => O(logN) - beacuse of recursion.
        // Apporach #: solve directly. TC => O(N), SC => O(logN)
        
        return buildTree(0, getLength(head) - 1);
    }
    
    private TreeNode buildTree(int left, int right) {
        
        // Base case
        if(left > right)
            return null;
        
        int mid = left + (right - left)/2; // this basically divides listnode into left and right part
        TreeNode leftNode = buildTree(left, mid - 1);
        
        TreeNode root = new TreeNode(Head.val);
        Head = Head.next;
        
        root.left = leftNode;
        root.right = buildTree(mid + 1, right);
        
        return root;
    }
    
    private int getLength(ListNode node) {
        int length = 0;
        while(node != null) {
            node = node.next;
            length++;
        }
        
        return length;
    }
}
