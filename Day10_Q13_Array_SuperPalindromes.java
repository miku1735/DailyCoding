



//Super Palindromes

/**
    Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.

    Given two positive integers left and right represented as strings, return the number of super-palindromes integers in the inclusive range [left, right].
 */


/**
 * Example 1:

    Input: left = "4", right = "1000"
    Output: 4
    Explanation: 4, 9, 121, and 484 are superpalindromes.
    Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
 */

 /**
  * Example 2:

    Input: left = "1", right = "2"
    Output: 1
  */

/**
 * Constraints:

    1 <= left.length, right.length <= 18
    left and right consist of only digits.
    left and right cannot have leading zeros.
    left and right represent integers in the range [1, 1018].
    left is less than or equal to right.
 */


class Solution {
    public static String toString(char[] a)
    {
        String string = new String(a);
        return string;
    }
    
    public boolean isPalindrome(String num){
        if(num.length() == 1) return true;
        int halfLength = num.length()/2;
        boolean flag = true;
        for(int i=0;i<halfLength;i++){
           if(num.charAt(i)!=num.charAt(num.length()-1-i)) flag = false;
        }
        return flag;
    }
    
    public long nextPalindrome(long prev){
        if(prev<10) return ++prev;
        if(prev==9) return 11;
        String prevString = String.valueOf(prev);
        int middle = prevString.length()/2;
        while(true){
            int c = prevString.charAt(middle)-'0';
            if(c==9){
                char charArray[] = prevString.toCharArray();
                while(true){
                    charArray[middle] = (char)(0+'0');
                    charArray[prevString.length()-1-middle] = (char)(0 + '0');
                    prev = Long.parseLong(toString(charArray));
                    middle--;
                    if(middle >=0){
                       int next = prevString.charAt(middle)-'0';
                       if(next!=9){
                         next++;
                         charArray[middle] = (char)(next+'0');
                         charArray[prevString.length()-1-middle] = (char)(next + '0');
                         prev = Long.parseLong(toString(charArray));
                         return prev;
                       }
                    }
                    else{
                        String val = "1";
                        for(int i=0;i<prevString.length()-1;i++){
                            val=val+"0";
                        }
                        return Long.parseLong(val+"1");
                    }
                }
            }
            else{
                c++;
                char charArray[] = prevString.toCharArray();
                charArray[middle] = (char)(c + '0');
                charArray[prevString.length()-1-middle] = (char)(c + '0');
                prev = Long.parseLong(toString(charArray));
                break;
            }
            
        }
        return prev;
    }
    
    public int superpalindromesInRange(String left, String right) {
        double leftLong = Long.parseLong(left);
        long rightLong = Long.parseLong(right);
        int count = 0;
        long nextNum = (long)Math.sqrt((double)leftLong);
        if(!isPalindrome(String.valueOf(nextNum))){
            left = String.valueOf(nextNum);
            int len = left.length()/2;
            char charArray[] = left.toCharArray();
            for(int i=0;i<len;i++){
                charArray[left.length()-1-i]=charArray[i];
            }
            long num = Long.parseLong(toString(charArray)); 
            int c = left.charAt(len)-'0';
            long newNum = nextPalindrome(num);
            nextNum = num>nextNum?num:newNum;
        }
        while(true){
            if(nextNum*nextNum <= rightLong){
                if(isPalindrome(String.valueOf(nextNum*nextNum))){
                   count++;
                } 
            }
            else break;
            nextNum = nextPalindrome(nextNum);
        }
        return count;
    }
}
