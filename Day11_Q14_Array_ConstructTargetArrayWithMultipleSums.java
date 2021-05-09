


///Construct Target Array With Multiple Sums



/**
    Given an array of integers target. From a starting array, A consisting of all 1's, you may perform the following procedure :

    let x be the sum of all elements currently in your array.
    choose index i, such that 0 <= i < target.size and set the value of A at index i to x.
    You may repeat this procedure as many times as needed.
    Return True if it is possible to construct the target array from A otherwise return False.
 */


/**
 * Example 1:

    Input: target = [9,3,5]
    Output: true
    Explanation: Start with [1, 1, 1] 
    [1, 1, 1], sum = 3 choose index 1
    [1, 3, 1], sum = 5 choose index 2
    [1, 3, 5], sum = 9 choose index 0
    [9, 3, 5] Done
 */

/**
 * Example 2:

    Input: target = [1,1,1,2]
    Output: false
    Explanation: Impossible to create target array from [1,1,1,1].
 */

/**
 * Example 3:

    Input: target = [8,5]
    Output: true
 */

/**
 * Constraints:

    N == target.length
    1 <= target.length <= 5 * 10^4
    1 <= target[i] <= 10^9
 */

class Solution {
    public boolean isPossible(int[] target) {
    PriorityQueue<Pair<Integer,Integer>> pq= 
                        new PriorityQueue<Pair<Integer,Integer>>((a,b)->b.getValue()-a.getValue());
        int sum = 0;
        boolean flag = true;
        if(target.length==1){
            if(target[0]==1) return true;
            return false;
        }
        for(int i = 0;i<target.length;i++){
            Pair<Integer,Integer> localPair = new Pair(i,target[i]); 
            pq.add(localPair);
            sum+=target[i];
        }
        while(!pq.isEmpty()){
            int maxIndex = pq.peek().getKey();
            int maxValue = pq.peek().getValue();
            if(maxValue==1) break;
            pq.poll(); 
            if(maxValue/(sum-maxValue)>2){
                int remainingSum = sum-maxValue;
                int temp = maxValue/remainingSum;
                temp-=2;
                maxValue = maxValue - temp*(remainingSum);
                sum = remainingSum + maxValue;
            }
            int newValue = maxValue - (sum-maxValue);
            if(newValue <= 0) return false;
            target[maxIndex] = newValue;
            sum = newValue + sum-maxValue; 
            if(newValue!=1){
                Pair<Integer,Integer> localPair = new Pair(maxIndex,newValue); 
                pq.add(localPair);
            }
        }
        
        return flag;
    }
}