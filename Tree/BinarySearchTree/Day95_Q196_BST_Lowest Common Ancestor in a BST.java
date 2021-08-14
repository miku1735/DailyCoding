


// Lowest Common Ancestor in a BST

/**
 * Given a Binary Search Tree (with all values unique) and two node values. Find the Lowest Common Ancestors of the two nodes in the BST.

Example 1:

Input:
              5
           /    \
         4       6
        /         \
       3           7
                    \
                     8
n1 = 7, n2 = 8
Output: 7
Example 2:

Input:
     2
   /   \
  1     3
n1 = 1, n2 = 3
Output: 2
Your Task:
You don't need to read input or print anything. Your task is to complete the function LCA() which takes the root Node of the BST and two integer values n1 and n2 as inputs and returns the Lowest Common Ancestor of the Nodes with values n1 and n2 in the given BST. 

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= N <= 104
 */
class BST
{   
    //Function to find the lowest common ancestor in a BST. 
    Node ans = null;
    int getDistance(Node root, int a, int b){
        if(root==null) return 0;
        
        int leftDis = getDistance(root.left, a, b);
        int rightDis = getDistance(root.right, a, b);
        
        if(leftDis != 0 && rightDis !=0){
            ans =  root;
            return ans.data;
        }
        else if((root.data == a || root.data == b) && Math.max(leftDis, rightDis)>0){
            ans = root;
            return ans.data;
        }
        else{
            int max = Math.max(leftDis, rightDis);
            int add = (root.data == a || root.data == b || max>0)?1:0;
            return  max + add;
        }
    }
	Node LCA(Node root, int a, int b)
	{
        int temp =  getDistance(root,a,b);
        return ans;
    }
    
}