package Java.MaxNumber_of_KSumPairs;

import java.util.HashMap;

/*
 * Space Complexity = O(1)
 * Time Complexity = O(n)
 */

public class HashMapApproch {
    public static int maxOperations(int[] nums, int k) {
        int no_of_pairs = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (map.containsKey(k - i)) {
                int frequnecy = map.get(k - i);
                if (frequnecy == 1) {
                    map.remove(k - i);
                } else {
                    map.put(k - i, frequnecy - 1);
                }
                no_of_pairs++;
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return no_of_pairs;
    }
}
