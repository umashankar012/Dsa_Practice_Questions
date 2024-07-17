package Arrays;

/* Source :: LeetCode 26
    Ques:: Remove Duplicates from Sorted Array
    Example 1:

    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
 
    Example 2:

    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
 

    Approach ->

        Brute Force Approach::
            *Declare a hash set
            *Run a loop from start to end
            *Put every element from array to set
            *Store the size of set in variable k
            *Now put all the elements in the array to the set
            *Return k
 
        Time Complexity - O(nlogn) + O(n)
        Space Complexity - O(n)


        Optimal Approach::  

            Intuition: We can think of using two pointers ‘i’ and ‘j’, we move ‘j’ till we don't get a number arr[j] which is different from arr[i]. 
            As we got a unique number we will increase the i pointer and update its value by arr[j]. 

            *Take variable as i is 0
            *Use a for loop by variable j and initialize to 1
            *if arr[i] != arr[j] increase i
            * And put arr[i] = arr[j]

            Time Complexity - O(n)
            Space Complexity - O(1)

 */

//Brute FOrce Code
 class Solution {
    public int removeDuplicates(int[] nums) {
      HashSet<Integer> set = new HashSet<Integer>(); //Create a hash set

      for(int i=0; i<nums.length; i++) {
        set.add(nums[i]); //add elements in a set
        
      } 
      int k = set.size(); //get the size of unique elements present in the set

      int j = 0;
      for(int x : set){
        nums[j++] = x; //assign element from a set to the array
      }
    Arrays.sort(nums,0,k); //sort the array to the range of k to maintain its sorted order
      return k; //return size
    }
}


//Optimal Approach
class Solution {
    public int removeDuplicates(int[] nums) {
      int i = 0;
        for(int j = 1; j<nums.length; j++) {
            if(nums[i] != nums[j]){ //when element are different
                i++; //increment the i variable
                nums[i] = nums[j]; //change the element of i variable with j element variable
            }
        }
        return i+1; //return the i+1 index
    }
}


