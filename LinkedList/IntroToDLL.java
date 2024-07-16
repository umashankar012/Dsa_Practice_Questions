/*

    Ques:: Introduction to Doubly Linked List
    Example 1:

    Input:
    n = 5
    arr = [1,2,3,4,5]
    Output:
    1 2 3 4 5
    Explanation: Linked list for the given array will be 1<->2<->3<->4<->5.
 */

 class Solution {
    Node constructDLL(int arr[]) {
        //array is empty
        if(arr.length == 0){
            return null;
        }
        //points to first element
        Node head = new Node(arr[0]);
       
        Node temp = head; //temp -> head
        
        int i = 1;
        //Traverse the array
        while(i < arr.length){
            Node newNode = new Node(arr[i]); //creation of new node
            temp.next = newNode; //set next pointer
            newNode.prev = temp; //set previous pointer
            temp = temp.next; //move temp forward
            i++;
        }
        
        return head;
    }
}
