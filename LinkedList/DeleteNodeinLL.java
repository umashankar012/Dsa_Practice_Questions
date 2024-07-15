/* Source:: LeetCode 237
    Ques:: Delete Node in a Linked List

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.

 
 */

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val; //copy the value of the next node into a current node
        node.next = node.next.next; //simply point the current node to current->next->next node
    }
}