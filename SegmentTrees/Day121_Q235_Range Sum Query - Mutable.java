
307. Range Sum Query - Mutable
Medium

3799

202

Add to List

Share
Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
At most 3 * 104 calls will be made to update and sumRange.







////  Time Complexity of update function will be O(n)   ----->>> Not Accepted 
class NumArray {

    int[] sumArray;
    public NumArray(int[] nums) {
        sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        for(int i = 1; i<nums.length;i++){
            sumArray[i] = sumArray[i-1] + nums[i];
        }
    }
    
    public void update(int index, int val) {
        int prevNo = 0;
        int diff = 0;
        if(index == 0){
            diff = val - sumArray[0];
            sumArray[0] = val;
        }
        else{
            prevNo =  sumArray[index] - sumArray[index-1];
            sumArray[index] = sumArray[index-1] + val;
            diff = val - prevNo;
        }
        
        for(int i = index+1; i<sumArray.length; i++){
            sumArray[i] += diff;
        }
    }
    
    public int sumRange(int left, int right) {
        if(left - 1 >= 0) return sumArray[right] - sumArray[left-1];
        return sumArray[right];
    }
}

/// Segment Trees...



class SegmentTree{
    int start, end;
    SegmentTree Left, Right;
    int sum;
    
    public SegmentTree(int start, int end){
        this.start = start;
        this.end = end;
        this.Left = null;
        this.Right = null;
        this.sum = 0;
    }
}


class NumArray {

    
    SegmentTree sumTree;
    
    public SegmentTree buildTree(int i, int j, int[] nums){
        
        SegmentTree newNode = new SegmentTree(i, j);
        
        if(i == j){
            newNode.sum = nums[i];
            return newNode;
        }
        
        int k = (i+j)/2;
        
        newNode.Left = buildTree(i, k, nums);
        newNode.Right = buildTree(k+1 , j, nums);
        newNode.sum = newNode.Left.sum + newNode.Right.sum;
        return newNode;
    }
    
    
    public NumArray(int[] nums) {
        sumTree = buildTree(0,nums.length-1, nums);
        
    }
    
    public void updateTree(SegmentTree root, int index, int val){
        int k = (root.start + root.end)/2;
        
        if( index == root.start && index == root.end){
            root.sum = val;
            return;
        }
        
        if(k >= index){
            updateTree(root.Left, index, val);
        }
        else{
            updateTree(root.Right, index, val);
        }
        
        root.sum = root.Left.sum + root.Right.sum;
    }
    
    public void update(int index, int val) {
        updateTree(sumTree, index, val);
    }
    
    public int sumRangeHelper(SegmentTree root, int Left, int Right){ 
        if(Left == root.start && Right == root.end){
            return root.sum;
        }
        else{
            int mid = (root.start+root.end)/2;
            if(Right <= mid) return sumRangeHelper(root.Left, Left, Right);
            else if(Left >= mid+1) return sumRangeHelper(root.Right, Left, Right);
            else return sumRangeHelper(root.Left, Left, mid) + sumRangeHelper(root.Right, mid+1, Right); 
        }
    }
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(sumTree, left, right);
    }
}










