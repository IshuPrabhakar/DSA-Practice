class Solution {
    public String multiply(String num1, String num2) {
        
        int m = num1.length();
        int n = num2.length();
        
        int[] res_arr = new int[m + n];
        
        // for num2
        for(int i = m - 1; i >= 0; i--) {
            
            // for num1
            for(int j = n - 1; j >= 0; j--) {

                // res[i + j + 1] is the carry
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res_arr[i + j + 1];
                
                // i + j tells us the position hwhere to insert values
                // i + j is the position of the carry 
                res_arr[i + j] += product / 10;
                
                // i + j + 1 is the position of last digit
                res_arr[i + j + 1] = product % 10;
                
            }
        }
        
        StringBuilder res = new StringBuilder();
        
        for(int i: res_arr) {
            if(!(res.length() == 0 && i == 0))
                res.append(i);
        }
        
        return (res.length() == 0)? "0" : res.toString();
    }
}
