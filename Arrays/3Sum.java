/* 
 15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.


Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/


//Brute Force Approach
/*First, we will declare a set data structure as we want unique triplets.
Then we will use the first loop(say i) that will run from 0 to n-1.
Inside it, there will be the second loop(say j) that will run from i+1 to n-1.
Then there will be the third loop(say k) that runs from j+1 to n-1.
Now, inside these 3 nested loops, we will check the sum i.e. arr[i]+arr[j]+arr[k], and if it is equal to the target i.e. 0 we will sort this triplet and insert it in the set data structure.
Finally, we will return the list of triplets stored in the set data structure.

T.C - O(n3 * log( no of triplets))
SC - O(2 * no of triplets)
*/

//Better Approach
/*
First, we will declare a set data structure as we want unique triplets.
Then we will use the first loop(say i) that will run from 0 to n-1.
Inside it, there will be the second loop(say j) that will run from i+1 to n-1.
Before the second loop, we will declare another HashSet to store the array elements as we intend to search for the third element using this HashSet.
Inside the second loop, we will calculate the value of the third element i.e. -(arr[i]+arr[j]).
If the third element exists in the HashSet, we will sort these 3 values i.e. arr[i], arr[j], and the third element, and insert it in the set data structure declared in step 1.
After that, we will insert the j-th element i.e. arr[j] in the HashSet as we only want to insert those array elements that are in between indices i and j.
Finally, we will return a list of triplets stored in the set data structure.

T.C - O(n2 * log (no of unique triplets))
S.C - O(n) + O(no of triplets)
*/


//Optimal Approach
/*
 First, we will sort the entire array.
 We will use a loop(say i) that will run from 0 to n-1. This i will represent the fixed pointer. In each iteration, this value will be fixed for all different values of the rest of the 2 pointers. Inside the loop, we will first check if the current and the previous element is the same and if it is we will do nothing and continue to the next value of i.
 After that, there will be 2 moving pointers i.e. j(starts from i+1) and k(starts from the last index). The pointer j will move forward and the pointer k will move backward until they cross each other while the value of i will be fixed.
 Now we will check the sum i.e. arr[i]+arr[j]+arr[k].
 If the sum is greater, then we need lesser elements and so we will decrease the value of k(i.e. k--). 
 If the sum is lesser than the target, we need a bigger value and so we will increase the value of j (i.e. j++). 
 If the sum is equal to the target, we will simply insert the triplet i.e. arr[i], arr[j], arr[k] into our answer and move the pointers j and k skipping the duplicate elements(i.e. by checking the adjacent elements while moving the pointers).
 Finally, we will have a list of unique triplets.
 
    T.C - O(n2) + O(nlogn)
    S.C - O(no of unique triplets)
 */