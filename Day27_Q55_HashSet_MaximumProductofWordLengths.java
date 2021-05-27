


// Maximum Product of Word Lengths


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
      HashSet hashArray[] = new HashSet[words.length];
      for(int i = 0;i<words.length;i++){
        String str = words[i];
        HashSet<Character> hash = new HashSet();
        for(Character j : str.toCharArray()){
          hash.add(j);
        }
        hashArray[i] = hash;
      }      
      int maxLength=0;
      for(int i=0;i<words.length;i++){
        for(int j=i+1;j<words.length;j++){
          HashSet h = hashArray[i];
          HashSet h2 = hashArray[j];
          boolean canChoosed = true;
          for(Object k : h){
            if(h2.contains(k)) canChoosed = false;
          }
          if(canChoosed != false){
            int newMax = words[i].length()*words[j].length();
            maxLength = newMax>maxLength?newMax:maxLength;
          }
        }
      }
        return maxLength;
    }
}