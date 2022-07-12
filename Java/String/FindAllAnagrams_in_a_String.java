class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        
        // making frequency
        int[] freq = new int[26];
        
        for(char c : p.toCharArray())
            freq[c - 'a']++;
        
        int left = 0;
        int right = 0;
        int count = p.length();
        
        // this is sliding window technique
        while (right < s.length()) {
            
            // here we are checking if a character of s is in our 
            // frequency table or not if it is then its frequency count will be
            // greater than or eqal to 1 in this case
            // we will deduce its count by 1 and also deduce count by 1
            // that means we found that matching character in s
            if(freq[s.charAt(right++) - 'a']-- >= 1)
                count--;
            
            // After decreament a lot of times, if our count becomes zero then
            // we found our anagram in range freom left to right then simply add this
            // to our result
            if(count == 0) 
                res.add(left);
            
            // now we found our result
            // then now we will start shifting our left pointer to find other anagrams
            // before that first check if the found anagram is of same length as p
            // if they are same then update the count in our frequency to find other
            // similary increament count as well
            if(right - left == p.length() && freq[s.charAt(left++) - 'a']++ >= 0)
                count++;
        }
        
        return res;
    }
}
