









/**
    Given the head of a singly linked list, return true if it is a palindrome.


    Constraints:

    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9
    

    Follow up: Could you do it in O(n) time and O(1) space?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    boolean b = true;
    ListNode root;
    public void checkIfPalindrome(ListNode head){
        if(head.next!=null){
            checkIfPalindrome(head.next);
        }
        if(head.val!= root.val){
            b=false;
            
        } 
        root=root.next;
    }
    
    public boolean isPalindrome(ListNode head) {
        root=head;
        checkIfPalindrome(head);
        return b;
    }
}