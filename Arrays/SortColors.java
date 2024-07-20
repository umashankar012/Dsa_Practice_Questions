/* leetcode 75
75. Sort Colors
 Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Approach ->

    Solution 1: Apply sort method on the array
        Time Complexity: O(nlogn)
        Space Complexity: O(1)

    Solution 2: 


    Solution 3:

 */


 class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums); // sorting method
    }
}




 class Solution {
    public void sortColors(int[] nums) {
        int temp[] = new int[3];
        for(int i=0; i<nums.length; i++) {
            int index = nums[i];
            temp[index]++;
        }
        int i = 0;
        for(int j=0; j<temp.length; j++) {
            int count = temp[j];
            while(count > 0) {
                nums[i] = j;
                i++;
                count--; 
            }
        }
    }
}


class Solution {
    public void sortColors(int[] nums) {
    int low = 0;
    int mid = 0;
    int high = nums.length-1;
    //Using of DNF algo
    while(mid <= high ){

        if(nums[mid] == 0) {
            int temp = nums[mid];  
            nums[mid] = nums[low]; 
            nums[low] = temp; 

            low++;
            mid++;
        }

        else if(nums[mid] == 1) {
            mid++;
        }

        else{
            int temp = nums[mid]; 
            nums[mid] = nums[high]; 
            nums[high] = temp;


            high--;
        }


    }
    }
}