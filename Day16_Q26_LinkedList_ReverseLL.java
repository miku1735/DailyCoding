



// Reverse LinkedList



/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
*/


/**
Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 */


class Solution {
    ListNode root = null ;
    public void getList(ListNode head){
        if(head.next==null){
            root = head;
            return;
        }
        getList(head.next);
        head.next.next = head;
        head.next=null;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null) return head;
        getList(head);
        System.out.print(root.val);
        return root;
    }
}