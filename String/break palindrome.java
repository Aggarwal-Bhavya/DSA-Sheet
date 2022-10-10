//Leetcode Q-1328
//Break a Palindrome
class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1)
            return "";
        
        char[] palinArray = palindrome.toCharArray();
        for(int i=0; i<palinArray.length/2; i++) {
            if(palinArray[i] != 'a') {
                palinArray[i] = 'a';
                return new String(palinArray);
            }
        }
        palinArray[palinArray.length-1] = 'b';
        return new String(palinArray);
    }
}