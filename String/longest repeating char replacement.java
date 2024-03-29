//Leetcode Q-424
//Longest Repeating Character Replacement
//Slinding window approach
//TC = O(n) and SC = O(1)
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int res = 0;
        int left = 0;
        int maxf = 0;
        
        for(int right = 0; right < s.length(); right++) {
            count[s.charAt(right)-'A']++;
            maxf = Math.max(maxf, count[s.charAt(right)-'A']);
            //slide the window
            while((right-left+1-maxf) > k) {
                count[s.charAt(left)-'A']--;
                left++;
            }
            //else calculate the resultant
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}