

// Convert Sorted List to Binary Search Tree

/**
    Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */


 /**
  * Example 1:


    Input: head = [-10,-3,0,5,9]
    Output: [0,-3,9,-10,null,5]
    Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
*/
/**
 * Example 2:

    Input: head = []
    Output: []
 */
/**
 * Example 3:

    Input: head = [0]
    Output: [0]
 */
/**
 * Example 4:

    Input: head = [1,3]
    Output: [3,1]
 */

/**
  * Constraints:

    The number of nodes in head is in the range [0, 2 * 104].
    -10^5 <= Node.val <= 10^5
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int findMiddleNode (ArrayList<Integer> list, int start, int end){
        if(end-start+1==1){
            return start;
        }
        if(end-start+1==2){
            return end;
        }
        return (start + (end-start)/2);
    }
    public TreeNode buildTree(TreeNode tree, ArrayList<Integer> list, int start, int end){
        if(end-start>=0 && end-start<list.size()) {
            int middle = findMiddleNode(list,start,end);
                System.out.println(start+" "+end+" "+middle);
            TreeNode newNode = new TreeNode(list.get(middle));

            newNode.left = buildTree(tree,list,start,middle-1);
            newNode.right = buildTree(tree,list,middle+1,end);
            return newNode;
        }
        return null;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            if(head.next==null) break;
            head = head.next;
        }
        
        int middle = findMiddleNode(list,0,list.size());
        if(list.size()==1) middle=0;
                        System.out.println(middle);
        TreeNode tree = new TreeNode(list.get(middle)); 
        if(list.size()>1){
            tree.left = buildTree(tree,list,0,middle-1);
            tree.right = buildTree(tree,list,middle+1,list.size()-1);
        }

        return tree;
    }
}