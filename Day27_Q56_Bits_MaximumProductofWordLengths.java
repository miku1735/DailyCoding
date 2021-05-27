



//["a","ab","abc","d","cd","bcd","abcd"]



/**
 * Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.

 

Example 1:

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
 

Constraints:

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.
 */


class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int stateArray[] = new int[len];
        int[] lens = new int[len];
        
        for(int i=0;i<len;i++){
          int state = 0;
          for(Character c: words[i].toCharArray()){
            state |= 1<<(c-'a');
          }
          stateArray[i] = state;
          lens[i] = words[i].length();
        }
      int maxLength = 0;
      for(int i = 0; i<len;i++){
        for(int j = i+1; j<len;j++){
          if((stateArray[i] & stateArray[j]) == 0){
            maxLength = Math.max(maxLength, lens[i] * lens[j]);
          }
        }
      }
      return maxLength;
    }
}