//Leetcode Q-1647
//Minimum deletions to make character frequencies unique
class Solution {
    //Approach 1: we decrement each duplicate frequenct until it becomes unique
    public int minDeletions(String s) {
        //store the frequency of each character
        int[] frequency = new int[26];
        for(int i=0; i<n.length(); i++) {
            frequency[s.charAt(i)-'a']++;
        }
        int deleteCount = 0;
        //Use a set to store the frequencies we have already seen
        HashSet<Integer> seenFrequency = new HashSet<>();
        for(int i=0; i<26; i++) {
            //Keep decrementing the frequency until it is unique
            while(frequency[i] > 0 && seenFrequency.contains(frequency[i])) {
                frequency[i]--;
                deleteCount;
            }
            //Add the newly occupied frequency to the set
            seenFrequency.add(frequency[i]);
        }
        return deleteCount;
    }

    
}