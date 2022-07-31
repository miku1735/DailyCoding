


// Kth smallest element

/**
 * Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Example 1:

Input:
N = 6
arr[] = 7 10 4 3 20 15
K = 3
Output : 7
Explanation :
3rd smallest element in the given 
array is 7.
Example 2:

Input:
N = 5
arr[] = 7 10 4 20 15
K = 4
Output : 15
Explanation :
4th smallest element in the given 
array is 15.
Your Task:
You don't have to read input or print anything. Your task is to complete the function kthSmallest() which takes the array, it's size and an integer k as input and returns the kth smallest element.
 
 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
Constraints:
1 <= N <= 105
1 <= arr[i] <= 105
1 <= K <= N
 */



Time Complexity of the sorting algo is nLog(n)
class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        Arrays.sort(arr);
        return arr[k-1];
    } 
}

Time Complexity of the sorting algo is n+ kLog(n)
class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        PriorityQueue<Integer> p = new PriorityQueue<>();
        
        for(int val : arr){
            p.add(val);
        }
        int result = 0;
        for(int i = 0; i<k;i++){
            result = p.poll();
        }
        return result;
    } 
}


Time Complexity of the Quick Select will be best - > O(n)
class Solution{
    
    public static void Swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        // Quick Select
        // A half version of Quick Sorting based on partitionin
        Swap(arr, l, (l+r)/2);
        
        int i = l;
        int j = r;
        
        while(i<j){
            while(i<arr.length && arr[i]<=arr[l]) i++;
            while(j>-1  && arr[j]>arr[l]) j--;
            if(i<j){
                Swap(arr, i, j);
            }
        }
        Swap(arr, l, j);
        if(j==k-1) return arr[j];
        else if(j>k-1) return kthSmallest(arr, l, j-1, k);
        else return kthSmallest(arr, j+1, r, k);
    } 
}

