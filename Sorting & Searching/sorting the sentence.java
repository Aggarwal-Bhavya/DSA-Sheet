//Leetcode Q-1859
//Sorting the sentence
//TC = O(N)
class Solution {
    public String sortSentence(String s) {
        String[] temp = new String[s.split(" ").length];
        for(String word: s.split(" ")) {
            int index = word.charAt(word.length()-1)-'0';
            temp[index-1] = word.substring(0, word.length()-1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<temp.length; i++) {
            sb.append(temp[i]).append(" ");
        }
        
        return sb.toString().trim();
    }
}