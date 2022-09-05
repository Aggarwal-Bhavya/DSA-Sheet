//Leetcode Q-1021
//Remove Outermost Parenthesis
//Approach 1: Usin' Stack
class Solution {
    public String removeOuterParentheses(String s) {
        return removeOuter(s).toString();
    }
    
    private StringBuilder removeOuter(String s) {
        Stack<Character> stack = new Stack<>();
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()) {
            if(s.charAt(i) == ')') {
                if(stack.size() != 1)   sb.append(')');
                stack.pop();
            } 
            else if(s.charAt(i) == '(') {
                if(!stack.isEmpty())    sb.append('(');
                stack.push('(');
            }
            i++;
        }
        return sb;
    }
}

//Approach 2: Without Stack
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int tracker = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                if(tracker > 0)
                    sb.append('(');
                tracker++;
            }
            else if(s.charAt(i) == ')') {
                tracker--;
                if(tracker > 0)
                    sb.append(')');
            }
        }
        return sb.toString();
    }
}