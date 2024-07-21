/* LeetCode
    169. Majority Element
    Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Solution :: 
    First Solution-> 
        *Create a first loop and for the first element make count as 1
        *Create a another loop inside when i and j indices are pointing the same element then continue
        *if they are not then increment the count
        *return the count

        Time COmplexity: O(n^2)
        Space Complexity: O(1)

    Second Solution->
        *Create a hashmap to store the frequencies of the elements
        *Traverse a hashmap and check which value is greater than n/2 of the array
        *if found then simply return the key
        *else return -1;

        Time Complexity: O(N)
        Space Complexity: O(N)

    Third Solution ->
        Apply Moore Voting Algorithm :: 
        *Create a variable element and count where element stores the value and count stores the number of occurences
        *Traverse a for loop in the array
        *if count is 0 then set the el with arr[i] and increment the count
        *if el is same as the arr[i] then increment the count
        *else it will be diffrent then simply decrement the count 
        *after reaching to the end of array we can return element variable where element stores the majority element

        Time Complexity: O(n)
        Space Complexity: O(1)
*/

class Solution {
    public int majorityElement(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int count = 1; //first counter element
            for(int j=0; j<nums.length; j++) {
                if(i == j) { //when indices are same
                    continue;
                }
                else if(nums[i] == nums[j]) { //when the values are same
                    count++;
                }
            }
            if(count > nums.length/2){
                return nums[i];
            }
        }
        return -1;
    }
}



class Solution {
    public int majorityElement(int[] nums) {
      HashMap<Integer,Integer> map = new HashMap<>(); //create a hashmap
      for(int i=0; i<nums.length; i++) {
        if(map.containsKey(nums[i])){ //if nums[i] contains
            int value = map.get(nums[i]); //get the value from hashmap
                map.put(nums[i],value+1); //insert the value increment by 1
            }
            //if not present then simply put 1
        else{
            map.put(nums[i],1);
        }
        }
        
      
    
    //Iterate the hashmap
      for(Map.Entry<Integer,Integer> e : map.entrySet()){
        if(e.getValue() > nums.length/2) { //check which key is greater than nums.length/2
            return e.getKey();
        }
      }
      return -1;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int el = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            if(count == 0) { //if the first element encounter
                el = nums[i];
                count = 1;
            }
            else if(el == nums[i]){ //element and the value are same
                count++;
            }
            else {
                count--; //not same decrement count
            }
        }
        return el;
    }
}