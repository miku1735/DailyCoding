


// Leaf at same level

/**
 * Given a Binary Tree, check if all leaves are at same level or not.

Example 1:

Input: 
            1
          /   \
         2     3

Output: 1

Explanation: 
Leaves 2 and 3 are at same level.

Example 2:

Input:
            10
          /    \
        20      30
       /  \        
     10    15

Output: 0

Explanation:
Leaves 10, 15 and 30 are not at same level.

Your Task: 
You dont need to read input or print anything. Complete the function check() which takes root node as input parameter and returns true/false depending on whether all the leaf nodes are at the same level or not.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)
 */

class Solution
{
    boolean check(Node root)
    {
	    Queue<Node> q = new LinkedList<Node>();
	    boolean ans = true;
	    int found = -1;
	    int level = 0;
	    q.add(root);
	    while(!q.isEmpty()){
	        int size = q.size();
	        for(int i=0;i<size;i++){
	            Node parent = q.poll();
	            if(parent.left == null && parent.right == null){
	                if(level!=found && found != -1) ans = false;
	                else found = level;
	            } 
	            if(parent.left != null) q.add(parent.left);
	            if(parent.right != null) q.add(parent.right);
	        }
	        level++;
	    }
	    return ans;
    }
}