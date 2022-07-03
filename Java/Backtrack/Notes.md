## Notes

1. Letter Combination of a phone number
- First make general backtracking solution
- make a new recursive funtion pass all the necessary paramaters:- resultant list, input array, list to strore current combination, index
```
  Ex backtrack(List<List<Integer>> res, int nums, List<Integer> curr, int index)
  // declare a base case
  if(index == nums.length){
      res.add(new ArrayList<>(curr));
    return;
  }
  
  // this will pick an element 
  Ex curr.add(nums[index])
  backtrack(List<List<Integer>> res, int nums, List<Integer> curr, int index) 
  
  // this will not pick an element
  curr.remove(curr.size()-1)  // this is bakrack step
  backtrack(List<List<Integer>> res, int nums, List<Integer> curr, int index) // call funtiom without picking element
```
- In this Question there is number which represent letter int it Ex 2 => abc, 3 => def
- So we have to loop through these character one by one as well to make combinations
- and make recursive call as well Do update index accordingly

2. 
