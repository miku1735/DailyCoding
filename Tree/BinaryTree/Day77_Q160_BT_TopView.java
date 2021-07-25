


// Top View

/**
 * Given a pointer to the root of a binary tree, print the top view of the binary tree.

The tree as seen from the top the nodes, is called the top view of the tree.

For example :

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Top View : 

Complete the function  and print the resulting values on a single line separated by space.

Input Format

You are given a function,

void topView(node * root) {

}
Constraints

 Nodes in the tree  

Output Format

Print the values on a single line separated by space.

Sample Input

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Sample Output

1 2 5 6

Explanation

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
From the top, only nodes  are visible.
 */

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    
    static void TopLeftView(Node node, ArrayList<Integer> res, int dis){
        if(node == null) return;
        if(dis>res.size()) res.add(node.data);
        TopLeftView(node.left, res, dis+1);
        TopLeftView(node.right, res, dis-1);
    }
    static void TopRightView(Node node, ArrayList<Integer> res, int dis){
        if(node == null) return;
        if(dis>res.size()) res.add(node.data);
        TopRightView(node.right, res, dis+1);
        TopRightView(node.left, res, dis-1);
    }
	public static void topView(Node node) {
      ArrayList<Integer> res = new ArrayList<Integer>();
        TopLeftView(node, res, 1);
        Collections.reverse(res);
        TopRightView(node, res, res.size());
        for(int i = 0; i<res.size(); i++)
            System.out.print(res.get(i)+" ");   
    }
	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}


// wrong ans by onl9 judge in GFG
// [23,17,65,9,19,38,69,7,10,18,21,37,43,67,74,1,8,null,14,null,null,20,22,33,null,39,53,66,68,70,null,null,4,null,null,13,16,null,null,null,null,29,35,null,40,51,62,null,null,null,null,null,71,3,5,11,null,15,null,27,32,34,36,null,41,45,52,58,63,null,72,2,null,null,6,null,12,null,null,24,28,30,null,null,null,null,null,null,42,44,47,null,null,57,61,null,64,null,73,null,null,null,null,null,null,null,26,null,null,null,31,null,null,null,null,46,49,55,null,60,null,null,null,null,null,25,null,null,null,null,null,48,50,54,56,59]

// Correct ans -> 2 1 7 9 17 23 65 69 74 72 73 
// Onl9 judge -> 2 1 7 9 17 23 65 69 74 63 64 