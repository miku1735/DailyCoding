



// Sum of the Longest Bloodline of a Tree (Sum of nodes on the longest path from root to leaf node)

/**
 * Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(), that find the sum of all nodes on the longest path from root to leaf node.
If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.

Example 1:

Input: 
        4        
       / \       
      2   5      
     / \ / \     
    7  1 2  3    
      /
     6
Output: 13
Explanation:
        4        
       / \       
      2   5      
     / \ / \     
    7  1 2  3 
      /
     6

The highlighted nodes (4, 2, 1, 6) above are 
part of the longest root to leaf path having
sum = (4 + 2 + 1 + 6) = 13
Example 2:

Input: 
          1
        /   \
       2     3
      / \   / \
     4   5 6   7
Output: 11
Your Task:
You don't need to read input or print anything. Your task is to complete the function sumOfLongRootToLeafPath() which takes root node of the tree as input parameter and returns an integer denoting the sum of the longest root to leaf path of the tree. If the tree is empty, return 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= Number of nodes <= 104
1 <= Data of a node <= 104
 */

class Ans{
    int height;
    int sum;
    Ans(int height, int sum){
        this.height = height;
        this.sum = sum;
    }
}

class Solution{
    
    public Ans getSum(Node root){
        if(root == null){
            return new Ans(0,0);
        }
        Ans left = getSum(root.left);
        Ans right = getSum(root.right);
        if(left.height>right.height){
            // System.out.println(left.height+" "+(left.sum+root.data));
            return new Ans(left.height+1,left.sum+root.data);
        }
        else if(left.height<right.height){
            // System.out.println(right.height+" "+(right.sum+root.data));
            return new Ans(right.height+1,right.sum+root.data);
        }
        else{
            // System.out.println(right.height+" "+(Math.max(right.sum,left.sum)+root.data));
            return new Ans(left.height+1,Math.max(right.sum,left.sum)+root.data);
        }
    }
    
    public int sumOfLongRootToLeafPath(Node root)
    {
        Ans ans = getSum(root);
        return ans.sum;
    }
}