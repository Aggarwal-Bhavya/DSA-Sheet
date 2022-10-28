//Leetcode Q-921
//Minimum Add to make Valid Parentheses

//Approach 1: Ensure balance variable
//TC = O(n) and SC = O(1)
class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0, bal = 0;
        for(int i=0; i<s.length(); i++) {
            bal += s.charAt(i) == '(' ? 1 : -1;
            if(bal == -1) {
                ans++;
                bal++;
            }
        }
        return ans + bal;
    }
}

//Approach 2: Use inbuilt methods
class Solution {
    public int minAddToMakeValid(String s) {
        while(s.contains("()")) 
            s = s.replace("()", "");
        return s.length();
    }
}

//Approach 3: Using Stack
//TC = O(n) and SC = O(n)
class Solution {
    public int minAddToMakeValid(String s) {
        int bal = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(!stack.isEmpty() && (ch == ')' && stack.peek() == '(')) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        return stack.size();
    }
}