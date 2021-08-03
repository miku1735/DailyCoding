


// Duplicate subtree in Binary Tree


/**
 * Given a binary tree, find out whether it contains a duplicate sub-tree of size two or more, or not.


Example 1 :

Input : 
               1
             /   \ 
           2       3
         /   \       \    
        4     5       2     
                     /  \    
                    4    5
Output : 1
Explanation : 
    2     
  /   \    
 4     5
is the duplicate sub-tree.
Example 2 :

Input : 
               1
             /   \ 
           2       3
Output: 0
Explanation: There is no duplicate sub-tree 
in the given binary tree.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function dupSub() which takes root of the tree as the only arguement and returns 1 if the binary tree contains a duplicate sub-tree of size two or more, else 0.
Note: Two same leaf nodes are not considered as subtree as size of a leaf node is one.


Constraints:
1 ≤ length of string ≤ 100
 */

class Solution {
    Map<Integer,int[]> m = new HashMap();
    int ans  = 0;
    int find(Node root){
        if(root==null) return 0;
        int left = find(root.left);
        int right = find(root.right);
        
        int leftData = -1;
        int rightData = -1;
        if(root.left!=null) leftData = root.left.data; 
        if(root.right!=null) rightData = root.right.data;
        
        if(Math.max(left,right)+1==2 && !m.containsKey(root.data)){
            m.put(root.data,new int[]{leftData, rightData});
        }
        else if(Math.max(left,right)+1==2){
            int[] ar = m.get(root.data);
            if(ar[0] == leftData && ar[1] == rightData) ans = 1;
        }
        return Math.max(left,right) + 1;
    }
    
    int dupSub(Node root) {
        find(root);
        // for(int[] a : m.values())
        //     System.out.println(Arrays.toString(a));
        return ans;
    }
}