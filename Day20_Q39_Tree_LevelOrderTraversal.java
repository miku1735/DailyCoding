

//Binary Tree Level Order Traversal


/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 */


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root==null) return levelOrder;
        Queue<TreeNode> buffer = new LinkedList<>();
        buffer.add(root);
        while(!buffer.isEmpty()){
            int len = buffer.size();
            System.out.println(len);
            List<Integer> row = new ArrayList();
            for(int i = 0;i<len;i++){
                TreeNode head = buffer.poll();
                row.add(head.val);
                if(head.left != null) buffer.add(head.left);
                if(head.right != null) buffer.add(head.right);
            }
            levelOrder.add(row);
        }
        return levelOrder;
    }
}