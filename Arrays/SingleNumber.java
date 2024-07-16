package Arrays;

/*  Source :: LeetCode  136
    Ques:: Single Number
    
    Example 1:
    Input: nums = [2,2,1]
    Output: 1

    Example 2:
    Input: nums = [4,1,2,1,2]
    Output: 4
    
    Example 3:
    Input: nums = [1]
    Output: 1
 

    Solution :: Find the XOR of all the elements in the array. It will provide the unique element
 */

 class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
}


