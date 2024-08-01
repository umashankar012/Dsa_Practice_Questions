/* 
229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109


Follow up: Could you solve the problem in linear time and in O(1) space?
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
       int n = nums.length; 
       HashMap<Integer,Integer> map = new HashMap<>();

       for(int i=0; i<nums.length; i++) {
            //previously added
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                map.put(nums[i],value+1);
            } 

            //not addedd previously
            else{
                map.put(nums[i],1);
            }
       } 
        //Answer list to be return
        ArrayList<Integer> list = new ArrayList<>();

        //Iteration in Map
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue() > n/3){
                list.add(e.getkey);
            }
        }

        return list;
    }
}


class Solution {
    public List<Integer> majorityElement(int[] nums) {
       int n = nums.length; 
        int cnt1 = 0; 
        int el1 = Integer.MIN_VALUE;

        int cnt2 = 0;
        int el2 = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            if(cnt1 == 0 && el2 != nums[i]) {
                cnt1++;
                el1 = nums[i];
            }
            else if(cnt2 == 0 && el1 != nums[i]) {
                cnt2++;
                el2 = nums[i];
            }
            else if(nums[i] == el1) {
                cnt1++;
            }
            else if(nums[i] == el2) {
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;

        for(int i=0; i<nums.length; i++) {
            if(el1 == nums[i]){
                cnt1++;
            }
            else if(el2 == nums[i]){
                cnt2++;
            }
        } 
        if(cnt1 > n/3){
            list.add(el1);
        }
        if(cnt2 > n/3){
            list.add(el2);
        } 
        return list;
    }
}