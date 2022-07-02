package Java;

/**
 * Given an array of non-negative integers nums, you are initially positioned at
 * the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * You can assume that you can always reach the last index.
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * 
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

public class CanJump2 {

    public int jump(int[] nums) {
        int minimumJump = 0, next = 0, curr = -1;
        int last = nums.length - 1;
        for (int i = 0; next < last; i++) {
            if (i > curr) {
                minimumJump++;
                curr = next;
            }
            next = Math.max(next, nums[i] + i);
        }
        return minimumJump;
    }
}
