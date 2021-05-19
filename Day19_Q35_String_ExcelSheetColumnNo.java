




// 171. Excel Sheet Column Number



/**
 * Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
Example 4:

Input: columnTitle = "FXSHRXW"
Output: 2147483647
 

Constraints:

1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].
 */

class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int power = 0;
        for(int c = columnTitle.length()-1;c>=0;c--){
            result += (int)Math.pow(26,power++) * (columnTitle.charAt(c)-64);
        }
        return result; 
    }
}