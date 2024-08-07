/*
Find Kth Rotation

Given an increasing sorted rotated array arr of distinct integers. The array is right-rotated k times. Find the value of k.
Let's suppose we have an array arr = [2, 4, 6, 9], so if we rotate it by 2 times so that it will look like this:
After 1st Rotation : [9, 2, 4, 6]
After 2nd Rotation : [6, 9, 2, 4]

Examples:

Input: arr = [5, 1, 2, 3, 4]
Output: 1
Explanation: The given array is 5 1 2 3 4. The original sorted array is 1 2 3 4 5. We can see that the array was rotated 1 times to the right.
Input: arr = [1, 2, 3, 4, 5]
Output: 0
Explanation: The given array is not rotated.

Expected Time Complexity: O(log(n))
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <=105
1 <= arri <= 107
 */

//Solution 1 :: 
/*
 Apply linear search to find the minimum element and return the index of the minimum element
 */

//Solution 2 :: 
//Apply the find minimum element algorithm by binary search in the array and store the index simultaneously and return the index

//T.C :: O(logn)
public int findKRotation(List<Integer> arr) {
    int low = 0, high = arr.size() - 1;
      int ans = Integer.MAX_VALUE;
      int index = -1;
      while (low <= high) {
          int mid = (low + high) / 2;
          //search space is already sorted
          //then arr[low] will always be
          //the minimum in that search space:
          if (arr.get(low) <= arr.get(high)) {
              if (arr.get(low) < ans) {
                  index = low;
                  ans = arr.get(low);
              }
              break;
          }

          //if left part is sorted:
          if (arr.get(low) <= arr.get(mid)) {
              // keep the minimum:
              if (arr.get(low) < ans) {
                  index = low;
                  ans = arr.get(low);
              }

              // Eliminate left half:
              low = mid + 1;
          } else { //if right part is sorted:

              // keep the minimum:
              if (arr.get(mid) < ans) {
                  index = mid;
                  ans = arr.get(mid);
              }

              // Eliminate right half:
              high = mid - 1;
          }
      }
      return index; 
  }