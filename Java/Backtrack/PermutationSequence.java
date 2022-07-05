class Solution {
    public String getPermutation(int n, int k) {
        
        // this is to store factorial of n-1 numbers
        int factorial = 1;
        
        // This is to store number upto n
        List<Integer> numbers = new ArrayList<>();
        
        // For storing answers
        String ans = "";
        
        for(int i = 1; i < n; i++){
            numbers.add(i);
            factorial *= i;
        }
        // Adding remaining numbers
        numbers.add(n);
        
        // all are in zero based indexing so reduce it
        k--;
        
        while(true){
            // all are in zero based indexing
            // this is beacuse we will be finiding our next number in this range i.e  k/factorial ex => 3/2 = 1
            int num = k/factorial;
            ans += numbers.get(num);
            
            // remove the picked number from the numbers list
            numbers.remove(num);
            
            if(numbers.size() == 0)
                break;
            
            k %= factorial; // this will the remainnig range at which we have to search for next number 
            factorial /= numbers.size(); // Since factorial is n-1 and at this stage our factorial should be reduce to n-2
            // to be less by 1 to the actual numbers size which will give range or divides toatal permutations to factorial blocks
            
        }
        
        return ans;
    }
}
