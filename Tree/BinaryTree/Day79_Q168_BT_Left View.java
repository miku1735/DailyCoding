


// Left View of Binary Tree

/**
 * Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8   

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3

Example 2:

Input:

Output: 10 20 40
Your Task:
You just have to complete the function leftView() that prints the left view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
0 <= Number of nodes <= 100
1 <= Data of a node <= 1000
 */

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node node)
    {
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
                if(i==0) res.add(parent.data);
            }
        }
        return res;
    }
}