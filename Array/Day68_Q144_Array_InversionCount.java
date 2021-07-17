



// Count Inversion

/**
 * Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).
 */
class Solution
{
    long res = 0;
    void merge(long left[],long[] right, long[] main){
        int i = 0, j = 0, k = 0;
        while(i != left.length && j != right.length){
            if(left[i]<= right[j]){
                main[k] = left[i];
                i++;
            }
            else{
                main[k] = right[j];
                res+=left.length-i;
                j++;
            }
            k++;
        }
        if(i==left.length){
            for(int m = j; m<right.length; m++){
                main[k] = right[m];
                k++;
            } 
        }
        else if(j==right.length){
            for(int m = i; m<left.length; m++){
                main[k] = left[m];
                k++;
            } 
        }
    }
    void mergeSort(long arr[])
    {
        int len = arr.length;
        if(len<2) return;
        int mid = len/2;
        
        long[] left = new long[mid];
        long[] right = new long[len-mid];
        
        for(int i = 0; i<mid; i++) left[i] = arr[i];
        for(int i = mid; i<len; i++) right[i-mid] = arr[i];
        
        mergeSort(left);
        mergeSort(right);
        merge(left,right,arr);
    }
    long inversionCount(long arr[], long N){
        mergeSort(arr);
        return res;
    }
}