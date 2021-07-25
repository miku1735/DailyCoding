



// ZigZag Tree Traversal

/**
 * Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.

 

Example 1:

Input:
        3
      /   \
     2     1
Output:
3 1 2
Example 2:

Input:
           7
        /     \
       9       7
     /  \     /   
    8    8   6     
   /  \
  10   9 
Output:
7 7 9 8 8 6 9 10 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function zigZagTraversal() which takes the root node of the Binary Tree as its input and returns a list containing the node values as they appear in the Zig-Zag Level-Order Traversal of the Tree.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1 <= N <= 104
 */
class GFG
{
	ArrayList<Integer> zigZagTraversal(Node node)
	{
	    Queue<Node> q = new LinkedList();
        ArrayList <Integer> res = new ArrayList<Integer>();
        q.add(node);
        boolean direction = false;
        while(!q.isEmpty()){
            ArrayList <Integer> temp = new ArrayList<Integer>();
            int size = q.size();
            for(int i = 0; i<size; i++){
                Node parent = q.poll();
                if(parent.left!=null) q.add(parent.left);
                if(parent.right!=null) q.add(parent.right);
                temp.add(parent.data);
            }
            if(direction){
                Collections.reverse(temp);
                direction = !direction;
            }
            else{
                direction = !direction; 
            }
            res.addAll(temp);
        }
        return res;
	}
}