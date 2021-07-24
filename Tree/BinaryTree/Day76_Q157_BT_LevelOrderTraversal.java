


// Level order traversal

/**
 * Given a binary tree, find its level order traversal.
Level order traversal of a tree is breadth-first traversal for the tree.


Example 1:

Input:
    1
  /   \ 
 3     2
Output:1 3 2
Example 2:

Input:
        10
     /      \
    20       30
  /   \
 40   60
Output:10 20 30 40 60 N N

Your Task:
You don't have to take any input. Complete the function levelOrder() that takes the root node as input parameter and returns a list of integers containing the level order traversal of the given Binary Tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 105
 */

class Solution
{
    static ArrayList <Integer> levelOrder(Node node) 
    {
        Queue<Node> q = new LinkedList();
        ArrayList <Integer> res = new ArrayList();
        q.add(node);
        while(!q.isEmpty())
            for(int i = 0; i<q.size(); i++){
                Node parent = q.poll();
                if(parent.left!=null) q.add(parent.left);
                if(parent.right!=null) q.add(parent.right);
                res.add(parent.data);
            }
        return res;
    }
}