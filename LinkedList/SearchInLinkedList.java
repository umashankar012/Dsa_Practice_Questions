/* Source :: GFG
    Ques:: Search in Linked List

    Input:
    n = 4
    1->2->3->4
    Key = 3
    Output:
    True
    Explanation:
    3 is present in Linked List, so the function returns true.
 
 */

 class Solution {
    static boolean searchKey(int n, Node head, int key) {
        //list is empty
        if(head == null) {
            return false;
        }
        Node temp = head; //temp -> head;
        //Traversing till last node
        while(temp != null) {
            
            if(temp.data == key){
                return true;
            }
            temp = temp.next; //move temp to next node
            
        }
        // if not found
        return false;
    }
}
