


// Median in a row-wise sorted Matrix

/**
 * Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.

Example 1:

Input:
R = 3, C = 3
M = [[1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]]

Output: 5

Explanation:
Sorting matrix elements gives us 
{1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 

Example 2:

Input:
R = 3, C = 1
M = [[1], [2], [3]]
Output: 2

Your Task:  
You don't need to read input or print anything. Your task is to complete the function median() which takes the integers R and C along with the 2D matrix as input parameters and returns the median of the matrix.

Expected Time Complexity: O(32 * R * log(C))
Expected Auxiliary Space: O(1)


Constraints:
1<= R,C <=150
1<= matrix[i][j] <=2000
 */

class Solution {
    int getUb(int pos, int[] a) {
        while (pos + 1 < a.length && a[pos] == a[pos + 1]) pos++;
        return pos + 1;

    }
    int getRank(int matrix[][], int target){
        int totalLess = 0;
        for(int[] a : matrix){
            int place = Arrays.binarySearch(a, target);
            if(place<0){
                totalLess+=(place*-1)-1;
            }
            else{
                place = getUb(place, a);
                totalLess+=place;
            }
        }
        return totalLess;
    }
    int median(int matrix[][], int r, int c) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] a : matrix){
            min = Math.min(min, a[0]);
            max = Math.max(max, a[c-1]);
        }
        
        int target = (r*c+1)/2;
        // System.out.println(target);
        while(min<max){
            int mid = (max+min)/2;
            int rank = getRank(matrix, mid);
            // System.out.println(min+" "+max+" "+rank);
            if(rank < target){
                min = mid+1;
            }
            else{
                max = mid;
            }
            
        }
        
        // System.out.println(getRank(matrix, 20));
        
        return min;
    }
}