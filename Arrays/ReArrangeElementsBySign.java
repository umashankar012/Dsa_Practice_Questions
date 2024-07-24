//Variety 1
/* 
Source :: LeetCode
2149. Rearrange Array Elements by Sign

You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

 

Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  
Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
 

Constraints:

2 <= nums.length <= 2 * 105
nums.length is even
1 <= |nums[i]| <= 105
nums consists of equal number of positive and negative integers.
 

It is not required to do the modifications in-place.

*/



//Time Complexity :: O(N)
//Space Complexity :: O(N)
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length; 
        int posArray[] = new int[n/2]; //create a positive sign array
        int negArray[] = new int[n/2]; //create a negative sign array
        
        int posArrayIndex = 0; //refer to positive array
        int negArrayIndex = 0; //refer to negative array

        for(int i=0; i<n; i++) {
            if(nums[i] >= 0) {
                posArray[posArrayIndex] = nums[i];
                posArrayIndex++;
            }

            else{
                negArray[negArrayIndex] = nums[i];
                negArrayIndex++;
            }
        }
        
        posArrayIndex = 0;
        negArrayIndex = 0;
        //insert positive values
        for(int i = 0; i<nums.length; i=i+2) {
            nums[i] = posArray[posArrayIndex++];
        }

        //insert negative values
        for(int i=1; i<nums.length; i=i+2){
            nums[i] = negArray[negArrayIndex++];
        }

        return nums;
    }
} 



//Time Complexity :: O(N)
//Space Complexity :: O(N)
public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A) {
    int n = A.size();

    // Define array for storing the ans separately.
    ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));

    // positive elements start from 0 and negative from 1.
    int posIndex = 0, negIndex = 1;
    for (int i = 0; i < n; i++) {

        // Fill negative elements in odd indices and inc by 2.
        if (A.get(i) < 0) {
            ans.set(negIndex, A.get(i));
            negIndex += 2;
        }

        // Fill positive elements in even indices and inc by 2.
        else {
            ans.set(posIndex, A.get(i));
            posIndex += 2;
        }
    }

    return ans;
}
}


//Variety 2 
/*
 When the positive and negative elements in the array are not equal  
 */

class Solution {
    public int[] rearrangeArray(int[] nums) {
        //Create a two array list of positive and negative elements
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                pos.add(nums[i]);
            }
            else{
                neg.add(nums[i]);
            }
        }
        //positive elements are greater than negative elements
        if(pos.size() > neg.size() ) {
            for(int i=0; i<neg.size();i++) { //loop till negative size and add the elements in the original array
                nums[2*i] = pos.get(i);
                nums[2*i+1] = neg.get(i);
            }
            int index = 2*neg.size(); //from where the elements are left
            for(int i=neg.size(); i<pos.size();i++) { //initialize from negative array size in the positive array
                nums[i] = pos.get(i);
                index++;
             }

            }

            //if negative elements are greater than positive elements
        else{
            for(int i=0; i<pos.size();i++) {
                nums[2*i] = pos.get(i);
                nums[2*i+1] = neg.get(i);
            }
            int index = 2*pos.size();
            for(int i=pos.size(); i<neg.size();i++) {
                nums[i] = neg.get(i);
                index++;
             }
            }
        }
    } 
