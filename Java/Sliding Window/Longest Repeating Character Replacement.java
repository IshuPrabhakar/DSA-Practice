class Solution {
    public int characterReplacement(String s, int k) {
        
        // To store the elements of window
        int[] freq = new int[26];
        
        int max_length = 0;
        int left = 0;
        
        int max_freq = 0;
        
        for(int right = 0; right < s.length(); right++) {
            
            // Update Frequency
            freq[s.charAt(right) - 'A']++;
            
            // Find max frequency of character
            max_freq = Math.max(freq[s.charAt(right) - 'A'], max_freq);
            
            // Find maximum replacement requried to make subarray longest repeeting
            int requiredReplacement = (right - left + 1) - max_freq;
            
            // if maximum replacement requried is greater than K the shift left pointer and decrement freq 
            if (requiredReplacement > k && left < s.length()) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            // A each time keep track of maximum left of window
            max_length = Math.max(max_length, right - left + 1);
        }
        
        return max_length;
    }
}
