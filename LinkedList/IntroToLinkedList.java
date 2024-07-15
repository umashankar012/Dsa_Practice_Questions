/*  Source -: GFG

 Ques :: Introduction to Linked List
 Input:
 n = 5
 arr = [1,2,3,4,5]
 Output:
 1 2 3 4 5
 Explanation: Linked list for the given array will be 1->2->3->4->5.

 */

 class Solution {
    static Node constructLL(int arr[]) {
        //if length of the array is 0
        if(arr.length == 0){
            return null;
        } 
        
        //first node created
        Node head = new Node(arr[0]);
        
        Node temp  = head; //temp -> head
        
        //link other nodes through array
        for(int i=1;i<arr.length; i++) {
            //create new node on every iteration 
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = temp.next;
        }
    return head;
    }
}