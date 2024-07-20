package Binary_Search;

/*LeetCode
704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Solution : 
    *Take two variables as low and high where low as 0 and high as n-1
    *Calculate the mid of the array by using (low + high)/2
    *if arr[mid] == key return mid
    *if arr[mid] > key then high = mid-1
    *else low = mid + 1
    *Traverse a loop until low is less than equals to high
    *if not found key then return -1
 
 */


class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2; //Calculate mid
            if(nums[mid] == target) { //if equals to target
                return mid;
            }

            else if(nums[mid] > target) { //target is greater than mid index element
                high = mid - 1;
            }

            else{
                low = mid + 1; //target is smaller than mid index element
            }
        }

        return -1;
    }
}

