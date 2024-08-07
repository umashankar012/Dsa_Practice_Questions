/*
 * 540. Single Element in a Sorted Array
 * 
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * 
 * Return the single element that appears only once.
 * 
 * Your solution must run in O(log n) time and O(1) space.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * 
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */

// Solution 1 ::
/*
 * Traverse a for loop with a variable say i
 * check if i equals to 0 then check arr[i]!=arr[i+1] then return arr[i]
 * check if i equals to n-1 then check arr[i]!=arr[i-1] then return arr[i]
 * if both the condition were not true then
 * check the arr[i]!=arr[i-1] && arr[i]!=arr[i+1] then return arr[i]
 * 
 * 
 * 
 * T.C :: O(N)
 */

// Solution 2 ::
/*
 * Using XOR Traverse a loop and return the ans
 * T.C :: O(n)
 */

// Solution 3 ::
/*
 * Apply Binary Search in the array
 * First check if the size of the array is 1 then return arr[0]
 * Check if arr[0] != arr[1] then return arr[0]
 * Check if arr[n-1] != arr[n-2] then return arr[n-1]
 * Now, initialize low = 1 and high = n-2
 * find mid and check arr[mid]!=arr[mid-1] && arr[mid] != arr[mid+1] then return
 * arr[mid]
 * Check the current mid is which part if mid has on even index and the and the
 * next element equals to the arr[mid] OR(||) if mid is odd index and the prev element is equal to the arr[mid] then it means we are on left part and do low = mid + 1

    else -> high = mid -1
return -1
 */


 public int singleNonDuplicate(int[] nums) {
    //size of array is 1
    if(nums.length == 1){
       return nums[0];
    }   

    if(nums[0] != nums[1]){
       return nums[0];
    }

   if(nums[nums.length-1] != nums[nums.length-2]){
       return nums[nums.length-1];
   }

   int low = 1;
   int high = nums.length-2;

   while(low <= high){
       int mid = low + (high - low)/2;
       if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
           return nums[mid];
       }   
       //check the current mid is in which half
       if((mid % 2 == 1 && nums[mid] == nums[mid-1]) || mid % 2 == 0 && nums[mid] == nums[mid+1] ){
           low = mid + 1;

       }
       else{
           high = mid -1;
       }
   }
   return -1;
   }