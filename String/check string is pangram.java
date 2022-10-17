//Leetcode Q-1832
//Check if sentence is pangram
//Pangram - every letter of English alphabet appears atleast once

//Approach 1: Locating each alphabet in sentence
class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26)
            return false;
        for(int i=0; i<26; i++) {
            if(sentence.indexOf('a' + i) == -1)
                return false;
        }
        return true;
    }
}
//TC = O(n) and SC = O(1)

//Approach 2: Use hash set and check if its size is 26
class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26)
            return false;
        
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        
        return set.size() == 26;
    }
}
//TC = O(n) and SC = O(1)

//Approach 3: Maintain a boolean array to check the presence of character in string
class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26)
            return false;
        boolean[] seen = new boolean[26];
        for(char curr: sentence.toCharArray()) {
            seen[curr-'a'] = true;
        }
        
        for(boolean status: seen)
            if(!status)
                return false;
        return true;
    }
}
//TC = O(n) and SC = O(1)