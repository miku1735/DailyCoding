


// Boundary Traversal of binary tree

/**
 * Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring the left subtree over the right subtree. 
Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

Example 1:

Input:
        1
      /   \
     2     3    
   
Output: 1 2 3
Explanation:


Example 2:

Input:
          20
        /   \
       8     22
     /   \    \
    4    12    25
        /  \ 
       10   14 

Output: 20 8 4 10 14 25 22
Explanation: 

 

 

 

 

 

 

 

 

Your Task:
This is a function problem. You don't have to take input. Just complete the function printBoundary() that takes the root node as input and returns an array containing the boundary values in anti-clockwise.

 

Expected Time Complexity: O(N). 
Expected Auxiliary Space: O(Height of the Tree).

 

Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 105
 */

class Solution
{
    void leftRight(Node node, ArrayList <Integer> left, ArrayList <Integer> right){
        Queue<Node> q = new LinkedList<Node>();
        
        q.add(node);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Node parent = q.poll();
                if(!(parent.left == null && parent.right == null)){
                    if(i==0) left.add(parent.data);
                    if(parent != node && size!=1 && i==size-1) right.add(parent.data);
                }
                if(parent.left != null)  q.add(parent.left);
                if(parent.right != null) q.add(parent.right);
            }
        }
    }
    void leafNodes(Node node, ArrayList <Integer> leaf){
        if(node == null) return;
        if(node.left == null && node.right == null){
            leaf.add(node.data);
        }
        leafNodes(node.left, leaf);
        leafNodes(node.right, leaf);
    }
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer> res = new ArrayList <Integer>();
	    ArrayList<Integer> leaf = new ArrayList <Integer>();
	    ArrayList<Integer> left = new ArrayList <Integer>();
	    ArrayList<Integer> right = new ArrayList <Integer>();
	    
	    leftRight(node,left,right);
	    leafNodes(node, leaf);
	    
	    Collections.reverse(right);
	    System.out.print(left+" "+leaf+" "+ right );
	    res.addAll(left);
	    res.addAll(leaf);
        res.addAll(right);	    
	    return res;
	}
}


// onl9 judge not printing the right view for this tree
// 4 10 N 5 5 N 6 7 N 8 8 N 8 11 N 3 4 N 1 3 N 8 6 N 11 11 N 5 8
// [4,10,null,5,5,null,6,7,null,8,8,null,8,11,null,3,4,null,1,3,null,8,6,null,11,11,null,5,8]