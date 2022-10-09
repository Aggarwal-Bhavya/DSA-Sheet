//Leetcode Q-1358
//Number of substrings containing all three characters
class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0, right = 0;
        int ans = 0;
        int n = s.length();
        int[] freq = new int[3];
        
        while(right < n) {
            freq[s.charAt(right)-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0 && left<=right) {
                int endPoints = n - right;
                ans += endPoints;
                freq[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }
}