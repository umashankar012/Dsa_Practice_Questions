/*
 * Find Nth root of M

You are given 2 numbers (n , m); the task is to find n√m (nth root of m).
 

Example 1:

Input: n = 2, m = 9
Output: 3
Explanation: 32 = 9
Example 2:

Input: n = 3, m = 9
Output: -1
Explanation: 3rd root of 9 is not
integer.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function NthRoot() which takes n and m as input parameter and returns the nth root of m. If the root is not integer then returns -1.
 

Expected Time Complexity: O(n* log(m))
Expected Space Complexity: O(1)
 

Constraints:
1 <= n <= 30
1 <= m <= 109


 */

//Solution 1 -> Linear Search T.C :: O(n^2)
// 0 -> ans < m
    //1 -> ans == m
    //2 -> ans > m
    public int exp(int mid, int n, int m){
        long ans = 1;
        for(int i=1; i<=n; i++) {
            ans = ans * mid;
            if(ans > m){
                
                return 2;
            }
        }
        if(ans == m){
            return 1;
        }
    
            return 0;
        
    }
public static int NthRoot(int n, int m) {
    //Use linear search on the answer space:
    for (int i = 1; i <= m; i++) {
        long val = func(i, n);
        if (val == (long)m) return i;
        else if (val > (long)m) break;
    }
    return -1;
}


//Solution 2 -> Binary Search T.C :: O(n * logm)
// 0 -> ans < m
    //1 -> ans == m
    //2 -> ans > m
    public int exp(int mid, int n, int m){
        long ans = 1;
        for(int i=1; i<=n; i++) {
            ans = ans * mid;
            if(ans > m){
                
                return 2;
            }
        }
        if(ans == m){
            return 1;
        }
    
            return 0;
        
    }
    public int NthRoot(int n, int m)
    {
        int low = 1;
        int high = m;
        while(low <= high) {
            int mid = low + (high - low )/2;
            if(exp(mid,n,m) == 1){
                return mid;
            }
            
            else if(exp(mid,n,m) == 0){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
    
        return -1;
    }