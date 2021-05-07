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
// class Solution {
    
//     HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); 
        
//     public int calHeight(TreeNode root){
//         if(root==null) return -1;
//         int left = calHeight(root.left) + 1;
//         if(root.left!=null) map.put(root.left.val,left-1);
//         int right = calHeight(root.right) + 1;
//         if(root.right!=null) map.put(root.right.val,right-1);
//         return Math.max(left,right);
//     }
//     public void InsertNodeInTree(TreeNode root, int value){
//         int leftHeight=0, rightHeight=0;
//         while(true){
//             if(value>root.val){
//                 if(root.right==null){
//                     root.right = new TreeNode(value);
//                     break;
//                 }
//                 else{
//                     root = root.right; 
//                 }
//             }
//             else if(value<root.val){
//                     if(root.left==null){
//                         root.left = new TreeNode(value);
//                         break;
//                     }
//                     else{
//                         root = root.left;
//                     }
//             }
//         }
//         System.out.print("Reached");
        
//         leftHeight = calHeight(root.left);
//         rightHeight = calHeight(root.right);
//         System.out.println("left"+leftHeight+"rightHeight"+rightHeight);
//         //rotate
//         if(leftHeight-rightHeight<-1){
//             //RR
//             if(map.get(root.right.val)>map.get(root.left.val)){
//                 System.out.print("RR");
//             }
//             //RL
//             else{
//                 System.out.print("RL");
//             }
//         }
//     }
    
//     public TreeNode sortedListToBST(ListNode head) {
//         if(head == null) return null;
//         TreeNode tree = new TreeNode(head.val);
//         head= head.next;
//         while(head!=null){
//             InsertNodeInTree(tree,head.val);
//             head = head.next;
//         }
//         System.out.print(map);
//         return tree;
//     }
// }