//Leetcode Q-96
//Unique Binary Search Trees
class Solution {
    public int numTrees(int n) {
        return catalanNumber(n);
    }
    
    private int catalanNumber(int n) {
        int[] catalan = new int[n+1];
        catalan[0] = catalan[1] = 1;
        
        for(int i=2; i<=n; i++) {
            catalan[i] = 0;
            for(int j=0; j<i; j++) 
                catalan[i] += catalan[j] * catalan[i-j-1];
        }
        return catalan[n];
    }
}
//TC = O(n) and SC = O(n)