/*  Source : LeetCode 1752 
    Ques:: Check if Array Is Sorted and Rotated

    Example 1:

    Input: nums = [3,4,5,1,2]
    Output: true
    Explanation: [1,2,3,4,5] is the original sorted array.
    You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].

    Example 2:

    Input: nums = [2,1,3,4]
    Output: false
    Explanation: There is no sorted array once rotated that can make nums.

    Example 3:

    Input: nums = [1,2,3]
    Output: true
    Explanation: [1,2,3] is the original sorted array.
    You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 
    Approach:: There is only pair should be exist in the array in which the prev element is greater than the first element
 */

 class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for(int i=1; i<n; i++) {
            if(nums[i-1] > nums[i]) { //check only one element is greater than prev element
                count++; //if true increment the count
            }
        }
        if(nums[n-1] > nums[0]) { //checks the last element is greater than first element or not
             count++;
        }
        return count <= 1;
    }
}
