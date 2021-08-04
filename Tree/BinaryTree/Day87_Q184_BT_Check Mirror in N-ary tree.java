


// Check Mirror in N-ary tree

/**
 * Given two n-ary trees. Check if they are mirror images of each other or not. You are also given e denoting the number of edges in both trees, and two arrays, A[] and B[]. Each array has 2*e space separated values u,v denoting an edge from u to v for the both trees.


Example 1:

Input:
n = 3, e = 2
A[] = {1, 2, 1, 3}
B[] = {1, 3, 1, 2}
Output:
1
Explanation:
   1          1
 / \        /  \
2   3      3    2 
As we can clearly see, the second tree
is mirror image of the first.
Example 2:

Input:
n = 3, e = 2
A[] = {1, 2, 1, 3}
B[] = {1, 2, 1, 3}
Output:
0
Explanation:
   1          1
 / \        /  \
2   3      2    3 
As we can clearly see, the second tree
isn't mirror image of the first.

Your Task:
You don't need to read input or print anything. Your task is to complete the function checkMirrorTree() which takes 2 Integers n, and e;  and two arrays A[] and B[] of size 2*e as input and returns 1 if the trees are mirror images of each other and 0 if not.


Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)


Constraints:
1 <= n,e <= 105
 */

class Pair implements Comparator<Pair>{
    int data1;
    int data2;
    Pair(){}
    Pair(int data1, int data2){
        this.data1 = data1;
        this.data2 = data2;
    }
    public int compare(Pair a, Pair b){
        return a.data1 - b.data1;
    }
    public String toString(){
        return "{" + data1 + ", " + data2 + "}";
    }
}

class Solution {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        
        Map<Integer, ArrayList<Integer>> A1 = new HashMap<Integer, ArrayList<Integer>>();
        Map<Integer, ArrayList<Integer>> B1 = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i=0;i<A.length;i+=2){
            if(A1.containsKey(A[i])){
                A1.get(A[i]).add(A[i+1]);
            }
            else{
                ArrayList<Integer> ar = new ArrayList<Integer>();
                ar.add(A[i+1]);
                A1.put(A[i], ar);
            }
            if(B1.containsKey(B[i])){
                B1.get(B[i]).add(B[i+1]);
            }
            else{
                ArrayList<Integer> ar = new ArrayList<Integer>();
                ar.add(B[i+1]);
                B1.put(B[i], ar);
            }
        }
        for(int a : A1.keySet()){
            ArrayList<Integer> ar = B1.get(a);
            Collections.reverse(ar);
            if(!A1.get(a).equals(ar)) return 0;
        }
        return 1;
    }
};