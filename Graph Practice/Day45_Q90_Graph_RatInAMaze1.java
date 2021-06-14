



// Rat in a Maze Problem - I


/**
 * Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is 
blocked.
Your Task:  
You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order. 
Note: In case of no path, return an empty list. The driver will output "-1" automatically.

Expected Time Complexity: O((N2)4).
Expected Auxiliary Space: O(L * X), L = length of the path, X = number of paths.

Constraints:
2 ≤ N ≤ 5
0 ≤ m[i][j] ≤ 1
 */


class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> list = new ArrayList();
        ArrayList<Character> path = new ArrayList();
        
        if(m[0][0] == 0) return list;
        DFS(0,0,list,path,n,m);
        Collections.sort(list);
        return list;
    }
    
    
    public static void DFS(int i, int j, ArrayList<String> list, ArrayList<Character> path, int n, int[][] m){
        if(i==n-1 && j==n-1){
            String newPath = "";
            for(Character c: path){
                newPath+=c;
            }
            list.add(newPath);
        }
        else{
            m[i][j] = 0;
            if(i+1<n && m[i+1][j] == 1){
                path.add('D');
                DFS(i+1,j,list,path,n,m);
                int index = path.size() - 1;
                path.remove(index);
            }
            if(i-1>=0 && m[i-1][j] == 1){
                path.add('U');
                DFS(i-1,j,list,path,n,m);
                int index = path.size() - 1;
                path.remove(index);
            }
            if(j+1<n && m[i][j+1] == 1){
                path.add('R');
                DFS(i,j+1,list,path,n,m);
                int index = path.size() - 1;
                path.remove(index);
            }
            if(j-1>=0 && m[i][j-1] == 1){
                path.add('L');
                DFS(i,j-1,list,path,n,m);
                int index = path.size() - 1;
                path.remove(index);
            }
            m[i][j] = 1;
        }
    }
}