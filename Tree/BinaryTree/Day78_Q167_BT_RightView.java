



// Right View

/**
 * Right View of Binary Tree 
Easy Accuracy: 51.66% Submissions: 62317 Points: 2
Given a Binary Tree, find Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.

Right view of following tree is 1 3 7 8.

          1
       /     \
     2        3
   /   \      /    \
  4     5   6    7
    \
     8

Example 1:

Input:
       1
    /    \
   3      2
Output: 1 2
Example 2:

Input:
     10
    /   \
  20     30
 /   \
40  60 
Output: 10 30 60
Your Task:
Just complete the function rightView() that takes node as parameter and returns the right view as a list. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
0 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 105
 */

class Solution{
    ArrayList<Integer> rightView(Node node) {
        Queue<Node> q = new LinkedList();
        ArrayList <Integer> res = new ArrayList();
        if(node==null) return res;
        q.add(node);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Node parent = q.poll();
                if(parent.left!=null) q.add(parent.left);
                if(parent.right!=null) q.add(parent.right);
                if(i==size-1) res.add(parent.data);
            }
        }
        return res;
    }
}