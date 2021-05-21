



// Find and Replace Pattern



/**
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
Example 2:

Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]
 

Constraints:

1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.
 */

class Solution {
    
    Map<Character,List<Integer>> adL = new HashMap();
    
    public boolean checkPattern(String word){
         Character c;
        HashSet<Character> set = new HashSet();
         for (Character key : adL.keySet()){
             List<Integer> list = adL.get(key);
             c = word.charAt(list.get(0));
             if(set.contains(c)) return false;
             set.add(c);
             for(int i=1;i<list.size();i++){
                 Character temp = word.charAt(list.get(i));
                 if(!temp.equals(c)) return false;
             }
         }
        return true; 
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> sr = new ArrayList();
        
        for(int i=0;i<pattern.length();i++){
            Character c = pattern.charAt(i);
            if(adL.containsKey(c)){
                List<Integer> row = adL.get(c);
                row.add(i);
                adL.put(c,row);
            }
            else{
                List<Integer> row = new ArrayList();
                row.add(i);
                adL.put(c,row);
            }
        }
        for(int i=0; i<words.length;i++){
            String word = words[i];
            if(checkPattern(word)){
                sr.add(word);
            }
        }
        return sr;
    }
}