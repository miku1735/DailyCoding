

// Maximum Depth of Binary Tree

/**
    Given the root of a binary tree, return its maximum depth.

    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    
 */


/**
 * Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: 3
    Example 2:

    Input: root = [1,null,2]
    Output: 2
    Example 3:

    Input: root = []
    Output: 0
    Example 4:

    Input: root = [0]
    Output: 1
 */

/**
 * Constraints:

    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100
 */
class Solution {
    int maxD = 0;
    public void findMax(TreeNode root, int height){
        if(root==null) return;
        maxD = maxD>height?maxD:height;
        findMax(root.left,height+1);
        findMax(root.right,height+1);
    }
    
    public int maxDepth(TreeNode root) {
        findMax(root,1);
        return maxD;
    }
}