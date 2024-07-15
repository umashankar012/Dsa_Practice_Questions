/* Source: GFG
    Ques :: Linked List Insertion At End

    Input: LinkedList: 1->2->3->4->5 , x = 6
    Output: 1->2->3->4->5->6
    Explanation: 

    We can see that 6 is inserted at the end of the linkedlist.
 
 */

 class Solution {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        //if list is empty
        if(head == null){
            head = newNode;
            return head;
        }
        
        Node temp = head; //temp -> head node
        //Traversing temp to the last node which points to null
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        
        return head;
        
    }
}