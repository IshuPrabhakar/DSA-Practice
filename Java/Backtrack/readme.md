## List of Important questions

These questions have to practice a lot and they also teach very important problem 
solving concept.

### Questions:-
- [Letter Combinations of a Phone Number](LetterCombinationsofaPhoneNumber.java)
- [Subsets](Subsets.java)
- [Subsets II](SubsetsII.java)
- [Permutation I](PermutationsI.java)
- [Permutation II](PermutationsII.java)
- [Combination Sum](CombinationSum.java)
- [Combination Sum II](CombinationSumII.java)
- [Combination Sum III](CombinationSumIII.java)
- [Combinations](Combinations.java)
- [N-Queens](N-Queens.java)
- [N-Queens II](N-QueensII.java)
- [Word Search](WordSearch.java)
- [Palindrome Partitioning](PalindromePartitioning.java)
- [Generate Parentheses](GenerateParentheses.java)
- [Permutation Sequence](PermutationSequence.java)
- [Letter Case Permutation](LetterCasePermutation.java)
- [Sudoku Solver](SudokuSolver.java)
- [Flood Fill](FloodFill.java)



### **Make decision tree first**

### 1. Letter Combination of a phone number
- First make general backtracking solution
- make a new recursive funtion pass all the necessary paramaters:- resultant list, input array, list to strore current combination, index
```java
 // base case
        if(curr.length() == digits.length()){
            // At this point we have generated all the combinations/subsequences so add it to the result
            res.add(curr.toString());
            return;
        }
        
        int element = digits.charAt(index) - '0';
        String value = map[element];
        
        // Since input is a string and represent number which in turn represent strings
        // so we have to traverse through all the character of string represented by digits
        for(int i = 0; i < value.length(); i++){
            
            curr.append(value.charAt(i));
            combinations(res, map, curr, digits, index + 1); // recursive call
            curr.deleteCharAt(curr.length()-1); // this is backtracking step
            // since we are generating all the possible combination so we need to clear
            // the current output so that next combination can be generated
        }
        
```
- In this Question there is number which represent letter int it Ex 2 => abc, 3 => def
- So we have to loop through these character one by one as well to make combinations
- and make recursive call as well Do update index accordingly


### 2. Subsets
- This is also known as Power Set
- generate all the subsets of the given array
```java
 // Base case
        if(index >= nums.size()){
            res.add(new ArrayList(temp));
            return;
        }
        
        // Here temp is used to stroe current combination
        
        temp.add(nums.get(index)); // this will pick an element from the list
        power(nums, res, index + 1, temp); // this call is with the picked element
        temp.remove(nums.get(index)); // this will remove that element from the list
        power(nums, res, index + 1, temp); // this call is without the picked element
```


### 3. Subsets II
- This is the follow up of previous question that may contain duplicates
- Step 1: Sort the array - to arrange duplicate in order i.e next to each other
- Skipping all the duplicates if we had skipped first element
```java
        while(index + 1 != nums.length && nums[index] == nums[index + 1]) index++;
```


### 4. Permutatations
- We have to make permutation of the given input Array
- i.e Pick all the elements and make permuataion
- There are two solutions for that 
- 1) with uisng same approch by picking an element one by one and store in temporary list
- 2) by Swapping the elements with first position i.e at first position we have 3 choice according to the input 
- array length then swap elements one by one and make recursive call to do rest of the task
```java
 public void permutation(int[] nums, List<List<Integer>> ans, int index){
        
        // Base case 
        if(index >= nums.length){
            // toList() is custom fuction to convert int[] to list
            ans.add(toList(nums));
            return;
        }
        
        // swapping element at index
        for(int i = index; i < nums.length; i++){
            
            // swapping element at index
            swap(nums, i, index );
            
            // Recursive call
            permutation(nums, ans , index + 1);
            
            // Undo swapping
            swap(nums, i, index);
        }
    }
```


### 5. Permutatations II
- same Question with addition that it may contain duplicates
- To solve this problem check if the element is picked before or not
- if picked then do not pick
```java
 private void backtrack(int[] nums, List<List<Integer>> res, int index){
        // Here we will make use of another data structure that will keep check of the duplicate element
        // if duplicate found we would simply skip that recursive call
        
        if(index >= nums.length){
            res.add(toList(nums));
            return;
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = index; i < nums.length; i++){
            
            // check if the element for which we are calling is same as previous or not
            if(set.add(nums[i]) == false) continue; // if element is present in set then it will return false else true if not present
            
            swap(nums, index, i); // swapping to place next element at first place
            backtrack(nums, res, index + 1); // recursive call
            swap(nums, index, i); // backtrack step
        }
    }
```

### 6. N- Queens
- First determine the attack range of the queen
- i.e horizontally, vertically and diagonaly for diagonaly observe the pattern of the diagonal elements
- store the diagonal pattern by row - column and row + column and column value since we will be traversing from left to right column wise.
- create char array to store the queen and mark positon as well if cannot place queen there skip that column.

```java
 // Base case
        if(row == n){
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        
        for(int c = 0; c < n; c++) {
            
            int positive_diagonal = row - c;
            int negative_diagonal = row + c;
            
            // check if queen is placed or not
            if( col.contains(c) || posDiagonal.contains(positive_diagonal) || negDiagonal.contains(negative_diagonal) )
                continue;
            
            // Creates new char row where we are trying to place queens
            char[] q = new char[n];
            Arrays.fill(q,'.');
            q[c] = 'Q';
            
            // if Queen is place then mark it's position on the set like in which column it is placed 
            col.add(c);
            posDiagonal.add(positive_diagonal); // this will mark the bottom-left to top-right diagonal 
            negDiagonal.add(negative_diagonal); // this will mark the top-left to bottom-right diagonal 
            currentCombination.add(new String(q));
               
            backtrack(currentCombination, row + 1, n, result);
               
            currentCombination.remove(currentCombination.size()-1);
            col.remove(c);
            posDiagonal.remove(positive_diagonal);
            negDiagonal.remove(negative_diagonal);
        }
```
- More [Link](https://leetcode.com/problems/n-queens-ii/discuss/2111857/JavaC%2B%2B-N-Queens-1-andand-2-oror-Almost-Same-Solution)


### 7. N-Queens II
- Same as previous question #### Note: Space complexity can be minimised using bit manupulation

### 8. Word Search
- first search the first charcter with help of loop the search for next with the help of recursion
- Search in all four direction that is make recursive call on all four direction
- Don't use the same charcter twice mark visited characters
```java
// if index reaches at the end that means we have found the word
        if(index == word.length())
            return true;
        
        // Checking the boundries if the character at which we are placed is not the required character
        if(row < 0 || col < 0 || row == m || col == n || board[row][col] != word.charAt(index))
            return false;
        
        // this is to prevent resuing of the same character
        char c = board[row][col];
        board[row][col] = 'x';
        
        // top direction
        boolean top = searchNext(board, word, row - 1, col, index + 1, m, n);
        // right direction
        boolean right = searchNext(board, word, row, col + 1, index + 1, m, n);
        // bottom direction
        boolean bottom = searchNext(board, word, row + 1, col, index + 1, m, n);
        // left direction
        boolean left = searchNext(board, word, row , col - 1, index + 1, m, n);
        
        board[row][col] = c; // undo change
        
        
        return top || right || bottom || left;
```

### 9. Generate Parenthesis
- first make dicison tree
- then first open bracket then only you can close it 
- close < open and open < n
- More on [Link](https://leetcode.com/problems/generate-parentheses/solution/)

### 10. kth Permutation of Sequence
- refer youtube videos for better explanation
