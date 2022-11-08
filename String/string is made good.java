//Leetcode Q-1544
//Make the string good

//Approach 1: Locating pairs of small and capital letters
class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        while(sb.length() > 1) {
            boolean find = false;
            
            for(int i=0; i<sb.length()-1; i++) {
                char currChar = sb.charAt(i), nextChar = sb.charAt(i+1);
                
                if(Math.abs(currChar-nextChar) == 32) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    find = true;
                    break;
                }
            }
            
            if(!find) 
                break;
        }
        return new String(sb);
    }
}
//TC = O(n^2) and SC = O(n)

//Approach 2: Recursively callin' our function
class Solution {
    public String makeGood(String s) {
        for(int i=0; i<s.length()-1; i++) {
            if(Math.abs(s.charAt(i)-s.charAt(i+1)) == 32)
                return makeGood(s.substring(0, i) + s.substring(i+2));
        }
        return s;
    }
}
//TC = O(n^2) and SC = O(n^2)

//Approach 3: Stack
class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch: s.toCharArray()) {
            if(!stack.isEmpty() && Math.abs(stack.peek()-ch) == 32)
                stack.pop();
            else 
                stack.add(ch);
        }
        
        StringBuilder ans = new StringBuilder();
        for (char currChar : stack) 
            ans.append(currChar);
        return ans.toString();
    }
}
//TC = O(n) and SC = O(n)
