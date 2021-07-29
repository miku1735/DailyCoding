


// Kth Ancestor in a Tree


/**
 * Given a binary tree of size  N, a node and a positive integer k., Your task is to complete the function kthAncestor(), the function should return the kth ancestor of the given node in the binary tree. If there does not exist any such ancestor then return -1.


Example 1:



Input:
     K = 2
     Node = 4
Output: 1
Explanation:
Since, K is 2 and node is 4, so we
first need to locate the node and
look k times its ancestors.
Here in this Case node 4 has 1 as his
2nd Ancestor aka the Root of the tree.
 

Example 2:

Input:
k=1 
node=3
      1
    /   \
    2     3

Output:
1
Explanation:
K=1 and node=3 ,Kth ancestor of node 3 is 1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
 */

class Tree
{
    int ans = -1;
    public int dis(Node root, int k, int node){
        if(root==null) return 0;
        int left = dis(root.left, k, node);
        int right = dis(root.right, k, node);
        
        if(Math.max(left,right) == k){
            ans = root.data;
            return ans;
        }
        else{
            int max = Math.max(left,right);
            int add = (root.data == node || max>0)?1:0;
            return max + add;
        }
    }
    public int kthAncestor(Node root, int k, int node)
    {
        int temp = dis(root, k, node);
        return ans;
    }
}