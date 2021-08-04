


// Minimum Swaps to Sort


/**
 * Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.


Example 1:

Input:
nums = {2, 8, 5, 4}
Output:
1
Explaination:
swap 8 with 4.
Example 2:

Input:
nums = {10, 19, 6, 3, 5}
Output:
2
Explaination:
swap 10 with 3 and swap 19 with 5.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minSwaps() which takes the nums as input parameter and returns an integer denoting the minimum number of swaps required to sort the array. If the array is already sorted, return 0. 


Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ n ≤ 105
1 ≤ numsi ≤ 106
 */


class Pair implements Comparator<Pair>{
    int data;
    int index;
    Pair(){}
    Pair(int data, int index){
        this.data = data;
        this.index = index;
    }
    public int compare(Pair a, Pair b){
        return a.data - b.data;
    }
    public String toString(){
        return "{" + data + ", " + index + "}";
    }
}

class Solution
{
    public int minSwaps(int nums[])
    {
        ArrayList<Pair> lst = new ArrayList<Pair>();
        for(int i = 0;i<nums.length;i++){
            lst.add(new Pair(nums[i],i));
        }
        Collections.sort(lst, new Pair());
        int swaps = 0;
        for(int i = 0; i<nums.length; i++){
            if(i!=lst.get(i).index){
                Pair temp = lst.get(lst.get(i).index);
                lst.set(lst.get(i).index, lst.get(i));
                lst.set(i,temp);
                i--;
                swaps++;
            }
        }
        return swaps;
    }
}