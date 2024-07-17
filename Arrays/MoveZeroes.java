package Arrays;

/* Source :: LeetCode 283
    Ques:: Move Zeroes
    
    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Example 2:

    Input: nums = [0]
    Output: [0]

    Approach::
        My Approach-> 
            Using two pointer->
                *Initialize i as 0
                *Using for loop and set j as i+1
                *if arr[i] == 0 and arr[j] != 0 will have swap each other and increment both 
                *if arr[i] != 0 and arr[j] !=0 so increase i and then swap the element of i and j

            Time Complexity - O(n)
            Space Complexity - O(1)



        Brute Force Approach->
                *Create a temp array 
                *Count the number of zeroes in the array
                *Fill the temp array with the non zero element
                *And add the zeroes at the temp array after insert non-zero elements
                *copy the temp array into the original array
                
            Time Complexity - O(n)
            Space Complexity - O(n)


        Optimal Approach ->
        *First, using a loop, we will place the pointer j. If we don’t find any 0, we will not perform the following steps.
        *After that, we will point i to index j+1 and start moving the pointer using a loop.
        *While moving the pointer i, we will do the following:
        *If a[i] != 0 i.e. a[i] is a non-zero element: We will swap a[i] and a[j]. Now, the current j is pointing to the non-zero element a[i]. So, we will shift the pointer j by 1 so that it can again point to the first zero.
        *Finally, our array will be set in the right manner.

        Time Complexity - O(n)
        Space Complextiy - O(1)
 */

        //My Approach
        int i = 0;
        for(int j=1; j<nums.length; j++) {
            if(nums[j] != 0 && nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            else if(nums[i] != 0 && nums[j] != 0){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

            }
        }

        //Brute Force Approach
        class Solution {
            public void moveZeroes(int[] nums) {
                
                ArrayList<Integer> list = new ArrayList<Integer>(); //Create a Array list
                int countZeroes = 0;
                for(int i = 0; i<nums.length; i++) {
                    if(nums[i] == 0){
                        countZeroes++; //Count the number of zeroes in the array
                    }
                }
        
                for(int i=0; i<nums.length; i++) {
                    if(nums[i] != 0) {
                        list.add(nums[i]); //add the non-zero elements in the list
                    }
                }
        
                while(countZeroes > 0){
                    list.add(0);
                    countZeroes--; //add the zeroes in the list 
                }
        
                for(int i=0; i<list.size();i++) {
                    nums[i] = list.get(i);  //copy the array with the list
                }
        
        
            }
        }



        //Optimal Approach
        class Solution {
            public void moveZeroes(int[] nums) {
                
                int j = -1;
                for(int i=0; i<nums.length; i++) {
                    if(nums[i] == 0) { //any zero element is encountered
                        j = i;
                        break;
                    }
                } 
                // if no zero is found
                if(j == -1){
                    return;
                }
        
                for(int i = j+1; i<nums.length; i++) {
                    if(nums[i] != 0){ 
                        //swap the elements
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
        
                        j++;
                    }
                }
        
            }
        }



        