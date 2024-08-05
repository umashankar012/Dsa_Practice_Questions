/* 
Number of occurrence

Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
Example 2:

Input:
N = 7, X = 4
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 0
Explanation: 4 is not present in the
given array.
Your Task:
You don't need to read input or print anything.
Your task is to complete the function count() which takes the array of integers arr, n, and x as parameters and returns an integer denoting the answer.
If x is not present in the array (arr) then return 0.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 106
1 ≤ X ≤ 106
*/

class Solution {
    public int firstOccurence(int []nums, int n, int target) {
      
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
    public int lastOccurence(int []nums,int n, int target) {
        
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

    int count(int[] arr, int n, int x) {
        int first = firstOccurence(arr, n, x);
        if(first == -1) return 0;
        
        int last = lastOccurence(arr, n ,x);
        return (last - first + 1);
        
    }
}