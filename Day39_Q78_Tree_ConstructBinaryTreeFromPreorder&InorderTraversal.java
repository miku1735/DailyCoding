



// Construct Binary Tree from Preorder and Inorder Traversal



/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
 */

class Solution {
    int preIndex = 0;

    public int searchRoot(int[] inorder, int val, int start, int end){
        int i;
        for(i = start;i<=end;i++){
            if(inorder[i] == val) return i;
        }
        return i;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end){
 
        if(start>end) return null;
        
        int rootIndex = searchRoot(inorder,preorder[preIndex],start, end);
        TreeNode node = new TreeNode(preorder[preIndex++],null,null);
        node.left  = buildTree(preorder,inorder, start, rootIndex-1);
        node.right = buildTree(preorder,inorder, rootIndex+1, end);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         return buildTree(preorder,inorder, 0, inorder.length-1);
    }
}