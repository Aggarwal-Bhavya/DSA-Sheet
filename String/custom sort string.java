//Leetcode Q-791
//Custom Sort String
class Solution {
    public String customSortString(String order, String s) {
        char[] sChar = s.toCharArray();
        int[] freq = new int[26];
        
        for(int i=0; i<sChar.length; i++)
            freq[sChar[i] - 'a']++;
        
        StringBuilder sb = new StringBuilder();
        int orderLen = order.length();
        for(int i=0; i<orderLen; i++) {
            char c = order.charAt(i);
            while(freq[c-'a'] != 0) {
                sb.append(c);
                freq[c-'a']--;
            }
        }
        
        for(int i=0; i<freq.length; i++) {
            if(freq[i] == 0)
                continue;
            while(freq[i] != 0) {
                sb.append((char)(i+'a'));
                freq[i]--;
            }
        }
        
        return sb.toString();
    }
}