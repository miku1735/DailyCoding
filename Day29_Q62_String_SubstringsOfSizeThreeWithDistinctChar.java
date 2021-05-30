


//Substrings of Size Three with Distinct Characters



/**
 * A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".
Example 2:

Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".
 

Constraints:

1 <= s.length <= 100
s​​​​​​ consists of lowercase English letters.
 */


class Solution {
    public int countGoodSubstrings(String s) {
      if(s.length()==1 || s.length()==2) return 0;
      HashSet set = new HashSet();
      Map<Character,Integer> map = new LinkedHashMap();
      
      int ans = 0; 
      for(int i=0;i<s.length();i++){
        if(i<3){
          if(map.containsKey(s.charAt(i))){
            map.put(s.charAt(i),map.get(s.charAt(i))+1);
          }
          else{
            map.put(s.charAt(i),1);
          }
          if(map.size()==3) ans++;
        }
        else{
          if(map.containsKey(s.charAt(i-3))){
            if(map.get(s.charAt(i-3))==1) map.remove(s.charAt(i-3));
            else{
              map.put(s.charAt(i-3),map.get(s.charAt(i-3))-1);
            }
          }
          if(map.containsKey(s.charAt(i))){
            map.put(s.charAt(i),map.get(s.charAt(i))+1);
          }
          else{
            map.put(s.charAt(i),1);
          }
          if(map.size()==3) ans++;
        }
      }
      
      return ans;
  }
}