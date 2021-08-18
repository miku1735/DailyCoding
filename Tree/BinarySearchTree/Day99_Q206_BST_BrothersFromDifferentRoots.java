


// Brothers From Different Roots

/**
 * Given two BSTs containing N1 and N2 distinct nodes respectively and given a value x. Your task is to complete the function countPairs(), that returns the count of all pairs from both the BSTs whose sum is equal to x.


Example 1:

Input:
BST1:
       5
     /   \
    3     7
   / \   / \
  2   4 6   8

BST2:
       10
     /    \
    6      15
   / \    /  \
  3   8  11   18

x = 16
Output:
3
Explanation:
The pairs are: (5, 11), (6, 10) and (8, 8)
 

Example 2:

Input:
BST1:
  1
   \
    3
   /
  2
BST2:
    3
   / \
  2   4
 /     
1

x = 4
Output:
3
Explanation:
The pairs are: (2, 2), (3, 1) and (1, 3)

Your Task:
You don't need to read input or print anything. Your task is to complete the function countPairs(), which takes 2 BST's as parameter in form of root1 and root2 and the integer x, that returns the count of all pairs from both the BSTs whose sum is equal to x.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 106
 */

class Pairs{
    int num = 0;
}
class Solution
{
    static void Inorder(Node root, Set<Integer> set, int sum, Pairs p){
        if(root==null) return;
        Inorder(root.left, set, sum, p);
        if(set.contains(sum-root.data)) p.num++;
        Inorder(root.right, set, sum, p);
    }
    static void fillMapByInorder(Node root, Set<Integer> set){
        if(root == null) return;
        set.add(root.data);
        fillMapByInorder(root.left, set);
        fillMapByInorder(root.right, set);
    }
	public static int countPairs(Node root1, Node root2, int x)
	{
		Set<Integer> set = new HashSet<Integer>();
		fillMapByInorder(root2, set);
		Pairs p = new Pairs();
		Inorder(root1, set, x, p);
		return p.num;
	}
}