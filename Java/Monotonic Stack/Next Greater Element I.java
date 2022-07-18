class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // Map to store num1
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // stack for next greater element
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        // iterating over nums2
        for(int i = 0; i < nums2.length; i++) {
            
            while(!stack.isEmpty() && stack.peek() < nums2[i])
                map.put(stack.pop(), nums2[i]);
            
            stack.push(nums2[i]);
        }
        
        // map will contain only those elements which has next greater element
        // then for any value we can find next greater element 
        
        for(int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        
        return nums1;
    }
}
