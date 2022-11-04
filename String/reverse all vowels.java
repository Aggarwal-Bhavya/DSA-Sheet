//Leetcode Q-345
//Reverse vowels of a string
//Approach 1: Two pass Algorithm
class Solution {
    public String reverseVowels(String s) {
        if(s.length() <= 1)
            return s;
        char[] str = s.toCharArray();
        ArrayList<Character> vowels = new ArrayList<>();
        
        for(char ch: str) {
            if(isVowel(ch))
                vowels.add(ch);
        }
        
        int j = vowels.size()-1;
        for(int i=0; i<str.length; i++) {
            if(isVowel(s.charAt(i)))
                str[i] = vowels.get(j--);
        }
        return String.valueOf(str);
    }
    
    private boolean isVowel(char ch) {
        return ch=='a' || ch=='A' || ch=='e' || ch=='E' || ch=='i' || ch=='I' || ch=='o' || ch=='O' || ch=='u' || ch=='U';
    }
}
//TC = O(n) and SC = O(n)

//Approach 2: One pass algorithm - Two Pointers
class Solution {
    public String reverseVowels(String s) {
        if(s.length() <= 1)
            return s;
        char[] str = s.toCharArray();
        
        int start = 0, end = str.length-1;
        while(start < end) {
            //find leftmost vowel
            while(start < str.length && !isVowel(str[start]))
                start++;
            //find rightmost vowel
            while(end >= 0 && !isVowel(str[end]))
                end--;
            //at start and end we have our respective vowels - perform swap
            if(start < end) 
                swap(str, start++, end--);
        }
        
        return String.valueOf(str);
    }
    
    private boolean isVowel(char ch) {
        return ch=='a' || ch=='A' || ch=='e' || ch=='E' || ch=='i' || ch=='I' || ch=='o' || ch=='O' || ch=='u' || ch=='U';
    }
    
    private void swap(char[] str, int x, int y) {
        char temp = str[x];
        str[x] = str[y];
        str[y] = temp;
    }
}
//TC = O(n) and SC = O(n)
