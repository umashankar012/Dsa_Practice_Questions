/*
 * Square root of a number

Given an integer n, find the square root of n. If n is not a perfect square, then return floor(√n).
Note: Floor value of an integer n is the greatest number less than or equal to n.

Examples:

Input: n = 5
Output: 2
Explanation: Since, 5 is not a perfect square, floor of square_root of 5 is 2.
Input: n = 4
Output: 2
Explanation: Since, 4 is a perfect square, so its square root is 2.
Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 107
 */


//Solution 

//Approach 1 ->  Linear Search -- > T.C :: O(n)
public static int floorSqrt(int n) {
    int ans = 0;
    // linear search on the answer space
    for (long i = 1; i <= n; i++) {
        long val = i * i;
        if (val <= (long) n) {
            ans = (int) i;
        } else {
            break;
        }
    }
    return ans;
}


//Approach 2 -> Using built in method --> T.C :: O(logN)
public static int floorSqrt(int n) {
    int ans = (int) Math.sqrt(n);
    return ans;
}

//Approach 3 -> Binary Search --> T.C :: O(logN)
long floorSqrt(long n) {
    long low = 1;
    long high = n;
    long ans = 1;
    while(low <= high) {
        long mid = low + (high - low)/2;
        if(mid*mid <= n){
            ans = mid;
            low = mid +1;
        }
        else if(mid * mid > n){
            high = mid - 1;
        }
        else{
            low = mid + 1;
        }
    }
    return ans;
}