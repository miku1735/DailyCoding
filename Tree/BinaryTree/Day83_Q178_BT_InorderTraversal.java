



// Inorder Traversal

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:


Input: root = [1,2]
Output: [2,1]
Example 5:


Input: root = [1,null,2]
Output: [1,2]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

// recursive Solution

class Solution {
    List<Integer> l = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            l.add(root.val);
            inorderTraversal(root.right);
            return l;
        }
        return l;
    }
}



// Iterative Solution

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st  = new Stack<TreeNode>();
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        TreeNode current = root;
        
         while(current!=null || !st.isEmpty()){
            // for(TreeNode a : st)
                // System.out.print(a.val);
            // System.out.println(ans);
            if(current!=null){
                st.add(current);
                current = current.left;
            }
            else{
                TreeNode temp = st.pop();
                ans.add(temp.val);
                if(temp.right!=null) current = temp.right;
             }
         }
        return ans;
    }
}




[15,7,16,1,12,null,null,null,2,10,14]