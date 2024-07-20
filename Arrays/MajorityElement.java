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
