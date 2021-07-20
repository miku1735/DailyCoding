

// Gold Mine Problem


/**Given a gold mine called M of (n x m) dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially the miner can start from any row in the first column. From a given cell, the miner can move

to the cell diagonally up towards the right 
to the right
to the cell diagonally down towards the right
Find out maximum amount of gold which he can collect.


Example 1:

Input: n = 3, m = 3
M = {{1, 3, 3},
     {2, 1, 4},
     {0, 6, 4}};
Output: 12
Explaination: 
The path is {(1,0) -> (2,1) -> (2,2)}.

Example 2:

Input: n = 4, m = 4
M = {{1, 3, 1, 5},
     {2, 2, 4, 1},
     {5, 0, 2, 3},
     {0, 6, 1, 2}};
Output: 16
Explaination: 
The path is {(2,0) -> (3,1) -> (2,2) 
-> (2,3)} or {(2,0) -> (1,1) -> (1,2) 
-> (0,3)}.

Your Task:
You do not need to read input or print anything. Your task is to complete the function maxGold() which takes the values n, m and the mine M as input parameters and returns the maximum amount of gold that can be collected.


Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)


Constraints:
1 ≤ n, m ≤ 50
1 ≤ M[i][j] ≤ 100 */

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        for(int i = m-2; i>=0; i--)
        for(int j = n-1; j>=0; j--){
            int local = 0;
            if(j>0)
                local = Math.max(local, M[j][i] + M[j-1][i+1]);
            if(j<n-1)
                local = Math.max(local, M[j][i] + M[j+1][i+1]);
            local = Math.max(local, M[j][i] + M[j][i+1]);
            M[j][i] = local;
        }
        int max = 0;
        for(int i = 0; i<n; i++)
            max = Math.max(max, M[i][0]);
        return max;
    }
}