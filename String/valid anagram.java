//Leetcode Q-242
//Valid Anagram
class Solution {
    //Approach 1 
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        return Arrays.equals(sArr, tArr);
    }

    //Approach 2
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        
        for(char c: s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0)+1);
        }
        
        for(char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }
        
        if(sMap.equals(tMap)){return true;}
        return false;
    }

    //Approach 3
    public boolean isAnagram(String s, String t) {
        int[] sMapping = new int[26];
        int[] tMapping = new int[26];
        
        for(char c: s.toCharArray()) {
            sMapping[c-'a']++;
        }
        
        for(char c: t.toCharArray()) {
            tMapping[c-'a']++;
        }
        
        for(int i=0; i<26; i++) {
            if(sMapping[i] != tMapping[i])  return false;
        }
        return true;
    }
}