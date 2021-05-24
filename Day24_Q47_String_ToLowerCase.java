



// To Lower Case


/**
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

 

Example 1:

Input: s = "Hello"
Output: "hello"
Example 2:

Input: s = "here"
Output: "here"
Example 3:

Input: s = "LOVELY"
Output: "lovely"
 

Constraints:

1 <= s.length <= 100
s consists of printable ASCII characters.
 */

class Solution {
    public String toLowerCase(String s) {
        for(int i = 0; i<s.length();i++){
            int c = s.charAt(i);
            if(c>=65 && c<=90){
                c=c+32;
            }
            char n =  (char) c;
            s = s.substring(0,i) + n + s.substring(i+1);
        }
        System.out.print(s);
        return s;
    }
}