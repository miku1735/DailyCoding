



// Find position of set bit 

/**
 * Find position of set bit 
 */

class Solution {
    static int findPosition(int N) {
        if(N==0) return -1;
        if((N&(N-1))==0) return (int)(Math.log(N)/Math.log(2)) + 1;
        return -1;
    }
};