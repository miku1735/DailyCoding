



// Construct Tree from Inorder & Preorder

/**
 * Given 2 Arrays of Inorder and preorder traversal. Construct a tree and print the Postorder traversal. 

Example 1:

Input:
N = 4
inorder[] = {1 6 8 7}
preorder[] = {1 6 7 8}
Output: 8 7 6 1
Example 2:

Input:
N = 6
inorder[] = {3 1 4 0 5 2}
preorder[] = {0 1 3 4 2 5}
Output: 3 4 1 5 2 0
Explanation: The tree will look like
       0
    /     \
   1       2
 /   \    /
3    4   5
Your Task:
Your task is to complete the function buildTree() which takes 3 arguments(inorder traversal array, preorder traversal array, and size of tree n) and returns the root node to the tree constructed. You are not required to print anything and a new line is added automatically (The post order of the returned tree is printed by the driver's code.)

Expected Time Complexity: O(N*N).
Expected Auxiliary Space: O(N).

Constraints:
1<=Number of Nodes<=1000
 */

class Solution
{
    int preOrderIndex = 0;
    public int findIndex(int[] inorder, int num){
        for(int i=0;i<inorder.length;i++){
            if(num == inorder[i]) return i;
        }
        return 0;
    }
    
    public Node makeTree(int[] inorder, int[] preorder, int start, int end){
        if(start>end) return null;
        int index = findIndex(inorder, preorder[preOrderIndex++]);
        
        Node left = makeTree(inorder, preorder, start, index-1);
        Node right = makeTree(inorder, preorder, index+1, end);
        
        Node node = new Node(inorder[index]);
        node.left = left;
        node.right = right;
        return node;
    }
    public Node buildTree(int inorder[], int preorder[], int n)
    {
        Node tree = makeTree(inorder, preorder, 0, n-1);
        return tree;
    }
}