/*  Source :: leetCode
121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
*/

/*
    Solution::
        Approach 1:
            *Use a for loop of ‘i’ from 0 to n.
            *Use another for loop of j from ‘i+1’ to n.
            *If arr[j] > arr[i] , take the difference and compare  and store it in the maxPro variable.
            *Return maxPro.

            TimeComplexity: O(n2)
            Space Complexity: O(1)

        Approach 2:
            *Create a variable maxPro and store 0 initially.
            *Create a variable minPrice and store some larger value(ex: MAX_VALUE) value initially.
            *Run a for loop from 0 to n.
            *Update the minPrice if it is greater than the current element of the array
            *Take the difference of the minPrice with the current element of the array and compare and maintain it in maxPro.
            *return the maxPro.

            Time Complexity: O(n)
            Space Complexity: O(1)
    */


class Solution {
    public int maxProfit(int[] arr) {

        int maxProfit = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {

                for(int k=i; k<=j; k++) {
                    maxProfit = Math.max(maxProfit, arr[j]-arr[i]);
                }

            }

         }
         if(maxProfit < 0) {
            return 0;
         }
         return maxProfit;
    }
}


class Solution {
    public int maxProfit(int[] arr) {

        int maxProfit = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {

                
                    maxProfit = Math.max(maxProfit, arr[j]-arr[i]);
                

            }

         }
         if(maxProfit < 0) {
            return 0;
         }
         return maxProfit;
    }
}



class Solution {
    public int maxProfit(int[] arr) {

        int minimal = Integer.MAX_VALUE; //stores the minimum value at which buy stock
        int profit = 0;  //stores how much profit is gained
        for(int i=0; i<arr.length; i++) {
            minimal = Math.min(minimal, arr[i]); 
            profit = Math.max(profit, arr[i]-minimal);
        }
        return profit;
    }
}