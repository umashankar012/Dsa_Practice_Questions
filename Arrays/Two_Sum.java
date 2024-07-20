package Arrays;

/* Source:: Leetcode 1
    Ques:: two sum
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.


    Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


    Approach:: 
        brute force approach-> 
            Simply traverse with the nested loops and check which pair has sum equals to target and simply return the indices
                Time Complexity: O(n2)
                Space Complexity: O(1)


        Better Approach ->
            *Create a Hashmap for all the value present in the array with their respective frequencies
            *with the help of loop for every i determine the remainder = target-arr[i] and check it contains in the map
            *if it contains then simply return the indices by storing them

            Time Complexity: O(n)
            Space Complexity: O(n)

 */


 class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []indices = new int[2];
        for(int i=0; i<nums.length-1; i++) {
            indices[0] = i;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    indices[1] = j;
                    return indices;
                }
            }
            
        }
    return new int[]{-1,-1};
    }
}



class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>(); //Creation of hashmap
        for(int i=0; i<nums.length; i++) {
            int remainder = target - nums[i]; // find the remaning number
            if(map.containsKey(remainder)){
                int index = map.get(remainder); 
                return new int[] {i,index};
            }
            else{
                map.put(nums[i],i);
            }
        }
    return new int[]{-1,-1};
    }
}


// The two sum problem is solved in two varieties where first one is return yes or no and the other variety is to give the index of the arrays 
//For  the first variety we can sort the array and take two pointer i and j at zero and n-1 index respectively .

//Compare the ith and jth value with sum if if it is greater than sum then simply decrases j otherwise increases i

