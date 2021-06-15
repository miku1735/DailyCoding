



// Steps by Knight



/**
 * Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.

Note:
The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.

 

Example 1:

Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:
3
Explanation:

Knight takes 3 step to reach from 
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
 

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function minStepToReachTarget() which takes the inital position of Knight (KnightPos), the target position of Knight (TargetPos) and the size of the chess board (N) as an input parameters and returns the minimum number of steps required by the knight to reach from its current position to the given target position.

 

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N2).

 

Constraints:
1 <= N <= 1000
1 <= Knight_pos(X, Y), Targer_pos(X, Y) <= N
 */


class Solution
{
    int res = Integer.MAX_VALUE;
    
    public int minStepToReachTarget(int K[], int T[], int N)
    {
        int[][] visited = new int[N+1][N+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(K);
        int level = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            while(size-->0){
                int[] pos = q.poll();
                
                if(pos[0] == T[0] && pos[1] == T[1]){
                    res = level;
                }
                
                if(pos[1]+2 <= N){
                    if(pos[0]-1>0 && visited[pos[0]-1][pos[1]+2]==0){
                        q.add(new int[] {pos[0]-1,pos[1]+2 });
                        visited[pos[0]-1][pos[1]+2]=1;
                    }
                    if(pos[0]+1<=N && visited[pos[0]+1][pos[1]+2]==0){
                        q.add(new int[] {pos[0]+1,pos[1]+2 });
                        visited[pos[0]+1][pos[1]+2]=1;
                    }
                }
                if(pos[1]-2 >0){
                    if(pos[0]-1>0 && visited[pos[0]-1][pos[1]-2]==0){
                        q.add(new int[] {pos[0]-1,pos[1]-2 });
                        visited[pos[0]-1][pos[1]-2]=1;
                    }
                    if(pos[0]+1<=N && visited[pos[0]+1][pos[1]-2]==0){
                        q.add(new int[] {pos[0]+1,pos[1]-2 });
                        visited[pos[0]+1][pos[1]-2]=1;
                    }
                }
                if(pos[0]+2 <= N){
                    if(pos[1]-1>0 && visited[pos[0]+2][pos[1]-1]==0){
                        q.add(new int[] {pos[0]+2,pos[1]-1});
                        visited[pos[0]+2][pos[1]-1]=1;
                    }
                    if(pos[1]+1<=N && visited[pos[0]+2][pos[1]+1]==0){
                        q.add(new int[] {pos[0]+2,pos[1]+1 });
                        visited[pos[0]+2][pos[1]+1]=1;
                    }
                }
                if(pos[0]-2>0){
                    if(pos[1]-1>0 && visited[pos[0]-2][pos[1]-1]==0){
                        q.add(new int[] {pos[0]-2,pos[1]-1});
                        visited[pos[0]-2][pos[1]-1]=1;
                    }
                    if(pos[1]+1<=N && visited[pos[0]-2][pos[1]+1]==0){
                        q.add(new int[] {pos[0]-2,pos[1]+1 });
                        visited[pos[0]-2][pos[1]+1]=1;
                    }
                }
            }
            level++;
        }
        return res;
    }
}