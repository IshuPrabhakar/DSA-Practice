class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        // this will count the frequency of letters in the strings
        int[] count = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            
            // one will increase the count another will decrease the count
            // if count remains constant 0 then they are anagrams
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        for(int c : count) {
            if(c != 0)
                return false;
        }
        
        return true;
    }
}
