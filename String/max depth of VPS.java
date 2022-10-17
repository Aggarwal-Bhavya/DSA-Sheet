//Leetcode Q-1614
//Maximum nesting depth of parentheses

//Example 1. depth("") = 0
//2. depth("1") = 0
//3. depth("()()") = 1
//4. depth("()(()())") = 2

//Approach 1: without stack
class Solution {
    public int maxDepth(String s) {
        int count = 0, max = 0;
        for(char c: s.toCharArray()) {
            if(c == '(')
                count++;
            else if(c == ')')
                max = Math.max(max, count--);
        }
        return max;
    }
}
//TC = O(n) and SC = O(1)

//Approach 2: Using stack
class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int temp = stack.size();
        for(char c: s.toCharArray()) {
            if(c == '(')
                stack.push(c);
            if(c == ')')
                stack.pop();
            if(temp < stack.size())
                temp = stack.size();
        }
        return temp;
    }
}