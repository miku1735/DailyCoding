


// Accepted

class Solution{

    public void Swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }    
    
    public int MiddlePartition(int arr[], int start, int end){
        int pivot = (end-start)/2 + start;
        Swap(arr,pivot,start);
        
        return Partition(arr, start, end);
    }
    public int Partition(int[] arr, int start, int end){
        int len = arr.length; 
        int i = start, j = end;
        int pivot = arr[start];
        
        while(i<j){
            while(i<len && arr[i]<=pivot) i++;
            while(j>-1  && arr[j]>pivot) j--;
            if(i<j){
                Swap(arr, i, j);
            }
        }
        Swap(arr, start, j);
        return j;
    }
    public void QuickSort(int[] arr, int l, int k){
        if(l<k){ // this shows array  have min 2 ele
            int pivot = MiddlePartition(arr, l, k);
            QuickSort(arr, l, pivot-1);
            QuickSort(arr, pivot+1, k);
        }
    }
    
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        new Solution().QuickSort(arr,0, arr.length-1);
        return arr[k-1];
    } 
}