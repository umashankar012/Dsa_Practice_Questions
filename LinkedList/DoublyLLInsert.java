/* Source : GFG
    Ques: Doubly linked list Insertion at given position
    Example 1:

Input:
LinkedList: 2<->4<->5
p = 2, x = 6 
Output: 2 4 5 6
Explanation: p = 2, and x = 6. So, 6 is
inserted after p, i.e, at position 3
(0-based indexing).
Example 2:

Input:
LinkedList: 1<->2<->3<->4
p = 0, x = 44
Output: 1 44 2 3 4
Explanation: p = 0, and x = 44 . So, 44
is inserted after p, i.e, at position 1
(0-based indexing).
 
 */

 class GfG
{   //Method to return the length of a list
    public static int length(Node head) {   
    
    int count = 0;
    Node temp = head;
    while(temp != null) {
        count++;
        temp = temp.next;
    }
    return count;
    }

    //Function to insert a new node at given position in doubly linked list.
    void addNode(Node head_ref, int pos, int data)
	{   //if the list is empty or position is outside the list
		if(head_ref == null || pos >= length(head_ref)){
		    return;
		}
		
		Node temp = head_ref; //temp ->head
		int count = 0;
		while(count < pos){
		    count++;
		    temp = temp.next;
		}
		
		Node newNode = new Node(data); //Creation of a new node
		
		if(temp.next == null) { //if temp -> last node and the temp->next = null
		    temp.next = newNode;
		    newNode.prev = temp;
		    return;
		}
		//if temp is in the list
        temp.next.prev = newNode;
        newNode.next =temp.next;
        
        temp.next = newNode;
        newNode.prev =temp;
        
		
		return ;
	}
}