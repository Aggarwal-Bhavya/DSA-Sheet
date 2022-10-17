//Leetcode Q-796
//Rotate String
//Approach 1: Creating shifts one by one
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        if(s.length() == 0)
            return true;
        if(s.equals(goal))
            return true;
        
        for(char x: s.toCharArray()) {
            String firstLetter = s.substring(0, 1);
            String other = s.substring(1, s.length());
            s = other + firstLetter;
            if(s.equals(goal))
                return true;
        }
        return false;
    }
}
//TC = O(n^2) and SC = O(1)

//Approach 2: Trick
//s = "abcde" and goal = "cdeab"
//s+s = "abcdeabcde" and s+s contains goal so true
//goal = "abced" s+s doesn't contain goal so false
class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s+s).contains(goal);
    }
}
//TC = O(n^2) and SC = O(n)