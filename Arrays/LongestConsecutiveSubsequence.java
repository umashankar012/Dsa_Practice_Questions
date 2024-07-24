/* Source :: LeetCode
128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109


Solution :: 
Approach 1:: 
    *Create a variable longest which return the length
    *Use a for loop with a variable i
    *For every element  i iteration set the count as 1 as initially it is consecutive and find the x+1 in an array
    *Now by using "linear Search" find the element x+1 in the array
    *if found then increase the x+1 to x+2 and so on and increment the count
    *if not found the find the max length for the one iteration
    *Now simply return the longest  


    Time Complexity : O(N^2)
    Space Complexity : O(1)


Approach 2 :: 

*/


class Solution {
    public int longestConsecutive(int[] nums) {
    
        //if array is empty
        if(nums.length == 0) {
            return 0;
        }

    int longest = 1; //found the length
    for(int i=0; i<nums.length; i++) {
        int x = nums[i]; 
        int count = 1; //every element is consecutive itself

        while(linearSearch(nums,x+1) == true) { //find the element in the array
            x = x+1; //found the next consecutive element
            count = count + 1; //increase the length
        }

        longest = Math.max(longest, count); //found the which length is greater
    }
        return longest;


    }
    //Method to find the element in the array
    public static boolean linearSearch(int arr[], int key) {
        for(int i=0; i<arr.length; i++) {
            if(key == arr[i] ) {
                return true;
            }
        }
        return false;
    }
}


class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //Sort the array first
        Arrays.sort(nums);

        int currCount = 0; //stores the number of consecutive elements
        int longest = 1; //store the length of consecutive element
        int lastSmaller = Integer.MIN_VALUE; //prevSmaller element

        for(int i=0; i<nums.length; i++) {
         
            if(nums[i]-1 == lastSmaller) { 
                currCount = currCount + 1;
                lastSmaller = nums[i];
            }
            else if(nums[i] != lastSmaller) {
                currCount  = 1;
                lastSmaller = nums[i];
            }

            longest = Math.max(longest, currCount);
        }
        return longest;
    }
}



class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>(); //Create a set to store element

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]); //add element in set
        }
        int longest  = 1; //find the longest consecutive series
      //Iterate through the set
       for(int it : set) {
        if(!set.contains(it-1)) {  // if it not contains the it-1
            int cnt = 1;
            int x = it;
            while(set.contains(x+1)) { //add the consecutive elements
                x = x + 1;
                cnt = cnt + 1;
            }
            longest = Math.max(longest, cnt); //stores the max between the longest and count
        }
        
       }
       return longest;
    }
