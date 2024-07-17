package Arrays;

/* Source :: GFG
    Ques:: Union of two Sorted Arrays
    Example 1:

Input: 
    n = 5, arr1[] = {1, 2, 3, 4, 5}  
    m = 5, arr2 [] = {1, 2, 3, 6, 7}
    Output: 
    1 2 3 4 5 6 7
    Explanation: 
    Distinct elements including both the arrays are: 1 2 3 4 5 6 7.

    Example 2:

    Input: 
    n = 5, arr1[] = {2, 2, 3, 4, 5}  
    m = 5, arr2[] = {1, 1, 2, 3, 4}
    Output: 
    1 2 3 4 5
    Explanation: 
    Distinct elements including both the arrays are: 1 2 3 4 5.

    Example 3:

    Input:
    n = 5, arr1[] = {1, 1, 1, 1, 1}
    m = 5, arr2[] = {2, 2, 2, 2, 2}
    Output: 
    1 2
    Explanation: 
    Distinct elements including both the arrays are: 1 2.


    Approach :: 
        Solution 5
 
 */



 class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {   
        //if both arrays are empty
        if(arr1.length == 0 && arr2.length == 0) {
            return list;
        }
        
        HashSet<Integer> set = new HashSet<Integer>(); //creation of HashSet to store unique element
        for(int i=0; i<n; i++) {
            set.add(arr1[i]); //add first array elements in a set
        }
        
        for(int i=0; i<m; i++){
            set.add(arr2[i]); //add second array elements in a set
        }
        ArrayList<Integer> list = new ArrayList<Integer>(); //Creation of list
        for(int x : set){ 
            list.add(x); //Add the set element in a list
        }
        
        Collections.sort(list); //sort the entire list
        //return array list
        return list;
    }
}



class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {   
       ArrayList<Integer>unionList = new ArrayList<Integer>(); //Creation of array list
       HashMap <Integer, Integer> map = new HashMap<>(); //creation of hashmap to store keyset and freq
       
       for(int i=0; i<n; i++) {
           map.put(arr1[i],1); //add array 1 elements in map
       }
       
       for(int i=0; i<m; i++) {
           map.put(arr2[i],1); //add array 2 elements in map
       }
       
       for(int i : map.keySet()){
           unionList.add(i); //add the map key set in the list
       }
       return unionList;
    }
}