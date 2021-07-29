



// Min distance between two given nodes of a Binary Tree


/**
 * Given a binary tree and two node values your task is to find the minimum distance between them.

Example 1:

Input:
        1
      /  \
     2    3
a = 2, b = 3
Output: 2
Explanation: The tree formed is:
       1
     /   \ 
    2     3
We need the distance between 2 and 3.
Being at node 2, we need to take two
steps ahead in order to reach node 3.
The path followed will be:
2 -> 1 -> 3. Hence, the result is 2. 
Your Task:
You don't need to read input or print anything. Your task is to complete the function findDist() which takes the root node of the Tree and the two node values a and b as input parameters and returns the minimum distance between the nodes represented by the two given node values.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 104
1 <= Data of a node <= 105



Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
 */
class GfG {
    int ans = 0;
    int getDistance(Node root, int a, int b){
        if(root==null) return 0;
        
        int leftDis = getDistance(root.left, a, b);
        int rightDis = getDistance(root.right, a, b);
        
        if(leftDis != 0 && rightDis !=0){
            ans =  leftDis + rightDis;
            return ans;
        }
        else if((root.data == a || root.data == b) && Math.max(leftDis, rightDis)>0){
            ans = Math.max(leftDis, rightDis);
            return ans;
        }
        else{
            int max = Math.max(leftDis, rightDis);
            int add = (root.data == a || root.data == b || max>0)?1:0;
            return  max + add;
        }
        
    }
    int findDist(Node root, int a, int b) {
        int temp =  getDistance(root,a,b);
        return ans;
    }
}