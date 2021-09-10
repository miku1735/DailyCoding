


// Count Sorted Vowel Strings


/**
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
Example 3:

Input: n = 33
Output: 66045
 

Constraints:

1 <= n <= 50 
 */

class Solution {
    public int countVowelStrings(int n) {
        int[] dump = new int[5];
        Arrays.fill(dump,1);
        int rowSum = 5;
        for(int i = 1;i<=n;i++){
            int localRowSum = rowSum;
            int newRowSum = 0;
            for(int j = 0;j<5;j++){
                int temp = localRowSum;
                localRowSum -= dump[j];
                dump[j] = temp;
                newRowSum += dump[j];
            }
            rowSum = newRowSum;
        }
        return dump[0];
    }
}