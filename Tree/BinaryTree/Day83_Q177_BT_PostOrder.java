



// Post order for\

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [3,2,1]
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
Output: [2,1]
 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */



 // recursive postorder traversal

 class Solution {
    List<Integer> l = new ArrayList<>(); 
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            l.add(root.val);
            return l;
        }
        return l;
    }
}


 // kind of dual stack problem
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st  = new Stack<TreeNode>();
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        st.add(root);
        while(!st.isEmpty()){
            TreeNode parent = st.pop();
            ans.add(parent.val);
            if(parent.left != null) st.add(parent.left);
            if(parent.right != null) st.add(parent.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}





 // single stack
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st  = new Stack<TreeNode>();
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        TreeNode current = root;
        while(current!=null || !st.isEmpty()){
            // for(TreeNode a : st)
            //     System.out.print(a.val);
            // System.out.println(ans);
            if(current!=null){
                st.add(current);
                current = current.left;
            }
            else{
                TreeNode peek = st.peek();
                if(peek.right==null){
                    ans.add(st.pop().val);
                    while(!st.isEmpty() && st.peek().right == peek){
                        peek = st.peek();
                        ans.add(st.pop().val);
                    }
                }
                else{
                    current = peek.right;
                }
            }
        }
        return ans;
    }
}