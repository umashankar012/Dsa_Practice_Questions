package Arrays;

/*  Source : LeetCode 268
 Ques:: Missing Number
 
Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Solution :: Find the sum of the array length -> sumTillN
            Find the sum of the array elements -> sumOfValues
            return sumTillN - sumOfValues
*/

class Solution {
    public int missingNumber(int[] nums) {
        int sumTilln = 0;
        for(int i=0; i<=nums.length; i++){
            sumTilln += i;
        }

        int sumOfValues = 0;
        for(int i=0; i<nums.length; i++){
            sumOfValues += nums[i];
        }

        return (sumTilln - sumOfValues);
    }
}
