package Java;

import java.util.HashMap;

/**
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * 
 * Space Complexity = ??
 * Time Complexity = ??
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        System.out.println(removeDuplicates("deeedbbcccbdaa", 2));
    }

    public static String removeDuplicates(String s, int k) {
        char[] s_charArray = s.toCharArray();
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s_charArray.length; i++) {
            if (map.containsKey(s_charArray[i])) {
                map.put(s_charArray[i], map.get(s_charArray[i]) + 1);
            } else {
                map.put(s_charArray[i], map.getOrDefault(s_charArray[i], 0) + 1);
            }

            // if (map.get(s_charArray[i]) == k) {
            //     map.remove(s_charArray[i]);
            //     for (int j = i; j <= i; j--) {
            //         //s.replace(s_charArray[i - 1], "")
            //     }
            // }
        }
        return s;
    }
}
