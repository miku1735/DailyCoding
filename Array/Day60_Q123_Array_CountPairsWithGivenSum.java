



// Count pairs with given sum


/**
 * Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.


Example 1:

Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output: 2
Explanation: 
arr[0] + arr[1] = 1 + 5 = 6 
and arr[1] + arr[3] = 5 + 1 = 6.

Example 2:

Input:
N = 4, X = 2
arr[] = {1, 1, 1, 1}
Output: 6
Explanation: 
Each 1 will produce sum 2 with any 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function getPairsCount() which takes arr[], n and k as input parameters and returns the number of pairs that have sum K.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
 */

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        Map<Integer,Integer> m = new HashMap();
        for(int i = 0;i<n;i++){
            if(m.containsKey(arr[i])){
                m.put(arr[i],m.get(arr[i])+1);
            }
            else m.put(arr[i],1);
        }
        int res=0;
        for(int i=0;i<n;i++){
            int srh  = k-arr[i];
            if(arr[i]==srh && m.containsKey(srh)){
                if(m.get(srh)<2) continue;
                else{
                    int local = 0;
                    for(int j=2;j<=m.get(srh);j++){
                        local+= j-1;
                    }
                    res+=local;
                    m.put(srh,0);
                }
            }
            else if(m.containsKey(srh)){
                res+= m.get(srh)*m.get(arr[i]);
                 m.put(arr[i],0);
                 m.put(srh,0);
            }
        }
        return res;
    }
}