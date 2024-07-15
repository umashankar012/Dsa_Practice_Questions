/* Source :: GFG
    Ques:: Count Linked List Nodes

    Input: LinkedList : 1->2->3->4->5

    Output: 5
    Explanation: Count of nodes in the linked list is 5, which is its length.
 
 */

 class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
       
       int count = 0;
       //list is empty
       if(head == null){
           return 0;
       }
       
       
       Node temp = head; // temp -> head
       //traverse till last node 
       while(temp != null){
           count++; //increment the counter
           temp = temp.next; //move temp to another node
       }
       return count;
    }
}