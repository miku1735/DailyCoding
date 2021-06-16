



// Generate Parentheses

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 */

 // 2^N * N (Time Complexity)
class Solution {
    
    public boolean valid(String str){
        Stack<Character> stack = new Stack();
        for(char c : str.toCharArray()){
            if(Objects.equals(c,'(')){
                stack.add(c);
            }
            else{
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty()?true:false;
    }
    public void generateParentesis(int index,String str, List<String> list, int n){
        if(index==n){
            if(valid(str)){
                list.add(str);
            }
        }
        else{
            generateParentesis(index+1,str+"(",list,n);
            generateParentesis(index+1,str+")",list,n);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        generateParentesis(0,"",list,n+n);
        return list;
    }
}



// better approach is count left bracket and right bracket .. and both be less than n and equal for a valid parantheses
