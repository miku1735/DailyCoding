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
    public ListNode deleteMiddle(ListNode head) {
        
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        ListNode prevPointer = head;
        
        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            prevPointer = slowPointer;
            slowPointer = slowPointer.next;
        }
        // delete  the pointer;
        
        if(prevPointer == head && prevPointer.next == null) head = null;
        else prevPointer.next = prevPointer.next.next;
        return head;
        
    }
}