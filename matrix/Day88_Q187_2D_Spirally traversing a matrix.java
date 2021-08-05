


// Spirally traversing a matrix


/**
 * Given a matrix of size r*c. Traverse the matrix in spiral form.

Example 1:

Input:
r = 4, c = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15,16}}
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
Explanation:

Example 2:

Input:
r = 3, c = 4  
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12}}
Output: 
1 2 3 4 8 12 11 10 9 5 6 7
Explanation:
Applying same technique as shown above, 
output for the 2nd testcase will be 
1 2 3 4 8 12 11 10 9 5 6 7.

Your Task:
You dont need to read input or print anything. Complete the function spirallyTraverse() that takes matrix, r and c as input parameters and returns a list of integers denoting the spiral traversal of matrix. 

Expected Time Complexity: O(r*c)
Expected Auxiliary Space: O(r*c), for returning the answer only.

Constraints:
1 <= r, c <= 100
0 <= matrixi <= 100
 */

class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        
        int i1 = 0, i2 = r, j1 = 0, j2=c;
        while(i1<i2 && j1<j2){
            for(int i=j1; i<j2; i++){
                if(i2>i1) lst.add(matrix[i1][i]);
            }
            i1++;
            for(int i = i1; i<i2; i++){
                if(j2>j1) lst.add(matrix[i][j2-1]);
            }
            j2--;
            for(int i = j2-1; i>=j1; i--){
                if(i2>i1) lst.add(matrix[i2-1][i]);
            }
            i2--;
            for(int i = i2-1; i>=i1; i--){
                if(j2>j1) lst.add(matrix[i][j1]);
            }
            j1++;
        }
        return lst;
    }
}
