class Solution {
    
    private int start;
    private int max;
    
    public String longestPalindrome(String s) {
        
        int left = 0;
        int right = 0;
        
        for(int i = 0; i < s.length(); i++) {
            
            isPalindrome(s, i, i + 1);
            isPalindrome(s, i, i);
        }
        
        // ex: "babad" start is at a = 1, end would be 1 + 3 = 4
        return s.substring(start, start + max); 
    }
    
    private void isPalindrome(String s, int left, int right) {
        
        if(s == null && left > right)
            return;
        
        // here we are expanding towards end thats why left--- and right++
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        if(max < right - left -1) {
            
            max = right - left -1;
            
            // left is at the starting of the palindromic substring
            start = left + 1;
        }
    }
}
