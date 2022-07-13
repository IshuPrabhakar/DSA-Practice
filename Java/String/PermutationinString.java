class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int len = s1.length();
        
        // TIme Complexity O(26*(s2-s1))
        
        if(len > s2.length())
            return false;
        
        // Make a hashmap of integers
        int[] freq = new int[26];
        
        for(char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for(int i = 0; i < s2.length(); i++) {
            
            // This is right pointer which will decrement frequency if found any character
            freq[s2.charAt(i) - 'a']--;
            
            // after length of s1 it again starts incrementing it so that
            // dcremented values can remain constant
            if(i - len >= 0)
                freq[s2.charAt(i - len) - 'a']++;
            
            // if at any point all value become zero then it contains permutation of s1
            if(isAllZero(freq))
                return true;
        }
        
        return false;
    }
    
    private boolean isAllZero(int[] freq) {
        
        for(int i: freq)
            if(i != 0)
                return false;
        
        return true;
    }
}
