package Java;

/**
 * You are given an integer array nums. You are initially positioned at the
 * array's first index, and each element in the array represents your maximum
 * jump length at that position.
 * 
 * Return true if you can reach the last index, or false otherwise.
 * 
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Time Complexity = O(n)
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        int last = nums[nums.length - 1];
        for (int i = nums.length - 1; i > -1; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        if (last == 0) {
            return true;
        } else {
            return false;
        }
    }

}
