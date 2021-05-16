




// Valid Anagrams



/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */


class Solution {
    public boolean isAnagram(String s, String t) {
        s.sort();
        t.sort();
        return s.equals(t);
    }
}

// Using hash Map it can be done in O(n) space and O(n) time 