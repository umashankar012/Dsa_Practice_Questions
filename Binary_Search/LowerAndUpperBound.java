/* 
34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

*/

//Lower and Upper Bound Method
public int lowerBound(int[] nums, int target) {
    int n = nums.length;
    int low = 0;
    int high = n-1;
    int ans = n;

    while(low <= high){
        int mid =  low + (high - low)/2;
        if(nums[mid] >= target){
            //may be an answer
            ans = mid;
            //look for left smaller index
            high = mid-1;
        }
        else{
            //look for right part
            low = mid + 1;
        }
    }
    return ans;

   }

   public int upperBound(int[] nums, int target) {
    int n = nums.length;
    int ans = n;
    int low = 0;
    int high = n-1;

    while(low <= high) {
        int mid = low + (high - low)/2;
        if(nums[mid] > target) {
            //maybe answer
            ans = mid;
            //look for left part
            high = mid-1;
        }
        else{
            //look for right part
            low = mid + 1;
        }
   }
   return ans;
   }
   
    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);
        //if lower bound equals to length OR the element at lower bound is not equal to target
        if(lb == nums.length || nums[lb] != target){
            return new int[]{-1, -1};
        }
        return new int[]{lb,ub-1};
    }

    //T.C -> O(2 * logN) => O(logN)

//Simple Binary Search Method
public int firstOccurence(int []nums, int target) {
    int n = nums.length;
    int first = -1;
    int low = 0;
    int high = n-1;

    while(low <= high){
        int mid = low + (high - low)/2;
        //if mid equals to the target
        if(nums[mid] == target){
           //update first
            first = mid;
        //search in left part
            high = mid - 1;

        }
        //mid element is smaller than target
        else if(nums[mid] < target){
            //go to left part
            low = mid + 1;
        }
        //if mid element is greter than target
        else{
            //go to right part
            high = mid - 1;

        }
    }
    return first;

}
public int lastOccurence(int []nums, int target) {
    int n = nums.length;
    int last = -1;
    int low = 0;
    int high = n-1;

    while(low <= high){
        int mid = low + (high - low)/2;
        //if mid element equals to target
        if(nums[mid] == target){
            last = mid; //update last
             low = mid+1; //move to right part
        }
        //mid element is smaller than target
        else if(nums[mid] < target){
            low = mid + 1; //move to right part
        } 
        //mid element is greater than target
        else{
            high = mid - 1; //move to right part
        }
    }
    return last;
    
}

public int[] searchRange(int[] nums, int target) {
    int first  = firstOccurence(nums,target);
    if(first == -1) return new int[]{-1,-1};

    int last = lastOccurence(nums, target);
    return new int[]{first, last};
}