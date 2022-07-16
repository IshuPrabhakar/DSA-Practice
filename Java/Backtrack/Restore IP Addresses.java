class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        // Resultant List
        List<String> result = new ArrayList<>();
        
        // Since each integer of ip is 3 digit long i.e. 255.255.255.255
        // so we cannot have more than 12 length
        if(s.length() > 12)
            return result;
        
        Backtrack(s, result, "", 0, 0);
        
        return result;
    }
    
    private void Backtrack(String s, List<String> result, String curr_ip, int index, int count) {
        
        // count is the number of dots
        if(count > 4)
            return;
        
        // if we have placed 4 dots and index reaches s.length() then we have found our solution
        if(count == 4 && index == s.length()) {
                result.add(new String(curr_ip));
            return;
        }
        
        // Since we can have upto 3 digits ip i.e. 255
        // for loop starts with 1 as it can help in incrementing the index
        for(int i = 1; i < 4; i++) {

            // Here index is the index which actually traverse to the end of s
            if(index + i > s.length())
                break;
            
            // extract sub ip
            String sub = s.substring(index, index + i);

            if((sub.startsWith("0") && sub.length() > 1) || ( i == 3 && Integer.parseInt(sub) >= 256))
                continue;
            // (count == 3 ? "": ".") this is to avoid putting extra dot at the end of ip
            Backtrack(s, result, curr_ip + sub + (count == 3 ? "": "."), index + i, count + 1);
        }
    }
}
