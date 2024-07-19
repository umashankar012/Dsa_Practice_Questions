package Arrays;

/* Source :: LeetCode 485
    Ques:: Max Consecutive Ones

    Example 1:

    Input: nums = [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.   
    Example 2:

    Input: nums = [1,0,1,1,0,1]
    Output: 2
 

    Approach->

        MyApproach:: 
            * Create a temp array to store the consecutive 1s
            * Creata variable j point at 0 index of the temp array
            * Make a for loop to starting of nums with i variable
            * if nums[i] equals to 1 then simply increase the value of arr[j] by 1
            * if nums[i] is not 1 then increase j index 
            *Return the max value of temp array gives max consecutive 1s

            T.C:: O(n)
            S.C:: O(n) //used a temp array of size n

        Optimal Approach::
            *Creata a variable count and maxi
            *Count stores the number of number of 1s and maxi will hold the maximum of count
            *if found 1 then increases count
            *if not found 1 then count = 0


 */


 //My Approach
 class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //Create an array with the value zeros
        int arr[] = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            arr[i] = 0;
        }


        //j -> arr[0]
        int j = 0;
        for(int i=0; i<nums.length; i++) {
            //if found 1 increase arr[j] by 1
            if(nums[i] == 1) { 
                arr[j] = arr[j] + 1;
            }
            //increase j 
            else{
                j++;
            }
        }
    
        //find max consecutive 1s in arr 
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
       int cons1s = max;
       return cons1s;

   
    }
}


//Optimal Approach
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0; //varibale to count number of 1s
        int maxi = 0; // stores maximum number of 1s
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1){ // if found 1
                count++;
            }
            else{
                count = 0; //if not found 1
            }
            maxi = Math.max(count,maxi);

        }
    return maxi;


    }
}