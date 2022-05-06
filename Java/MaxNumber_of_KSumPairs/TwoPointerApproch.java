package Java.MaxNumber_of_KSumPairs;

import java.util.Arrays;

/*
 * Space Complexity = O(1)
 * Time Complexity = O(nLogn)
 */

public class TwoPointerApproch {
    public static int maxOperations(int[] nums, int k) {
        int no_of_pairs = 0;
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;

        while (start < end) {
            if (nums[end] + nums[start] > k) {
                end--;
            } else if (nums[end] + nums[start] < k) {
                start--;
            } else {
                no_of_pairs++;
                end--;
                start++;
            }
        }

        return no_of_pairs;
    }
}
