package Arrays;

/*  Source :: GFG
    Ques:: Longest Sub-Array with Sum K

    Input :
    arr[] = {10, 5, 2, 7, 1, 9}, k = 15
    Output : 4
    Explanation:
    The sub-array is {5, 2, 7, 1}.
    Input : 
    arr[] = {-1, 2, 3}, k = 6
    Output : 0
    Explanation: 
    There is no such sub-array with sum 6.
 

    Approaches ->
        Brute-Force Approach ::
            Naive Approach (Brute-force approach): 
            Here, in this approach, we are going to generate all possible subarrays to solve this problem.

            *First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = size of the array).
            
 */


 class Solution{
       
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        int len = 0; //find the length
        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                long sum = 0;
                for(int k = i; k<=j; k++) {
                    sum += A[k];
                }
                if(sum == K){
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }
    
    
}

