



// MergeSorted


/**
 * Given an array arr[], its starting position l and its ending position r. Sort the array using merge sort algorithm.
Example 1:

Input:
N = 5
arr[] = {4 1 3 9 7}
Output:
1 3 4 7 9
Example 2:

Input:
N = 10
arr[] = {10 9 8 7 6 5 4 3 2 1}
Output:
1 2 3 4 5 6 7 8 9 10

Your Task:
You don't need to take the input or print anything. Your task is to complete the function merge() which takes arr[], l, m, r as its input parameters and modifies arr[] in-place such that it is sorted from position l to position r, and function mergeSort() which uses merge() to sort the array in ascending order using merge sort algorithm.

Expected Time Complexity: O(nlogn) 
Expected Auxiliary Space: O(n)

Constraints:
1 <= N <= 105
1 <= arr[i] <= 103
 */


class Solution
{
    void merge(int left[],int[] right, int[] main){
        int i = 0, j = 0, k = 0;
        while(i != left.length && j != right.length){
            if(left[i]<= right[j]){
                main[k] = left[i];
                i++;
            }
            else{
                main[k] = right[j];
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
    void mergeSort(int arr[], int l, int r)
    {
        int len = arr.length;
        if(len<2) return;
        int mid = len/2;
        
        int[] left = new int[mid];
        int[] right = new int[len-mid];
        
        for(int i = 0; i<mid; i++) left[i] = arr[i];
        for(int i = mid; i<len; i++) right[i-mid] = arr[i];
        
        mergeSort(left,l,r);
        mergeSort(right,l,r);
        merge(left,right,arr);
    }
}