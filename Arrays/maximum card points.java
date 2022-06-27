//Leetcode Q-1423
//Maximum points you can obtain from cards
class Solution {
    //Approach 1
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0, currSum = 0;
        for(int point: cardPoints) 
            totalSum += point;
        
        if(k == cardPoints.length)  return totalSum;
        //first sliding window from 0 to n-k sum
        for(int i=0; i<cardPoints.length-k; i++) {
            currSum += cardPoints[i];
        }
        
        int ans = totalSum - currSum;
        for(int i=cardPoints.length-k; i<cardPoints.length; i++) {
            currSum += cardPoints[i];
            currSum -= cardPoints[i-(cardPoints.length-k)];
            ans = Math.max(ans, totalSum-currSum);
        }
        return ans;
    }

    //Approach 2
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, totalSum = 0;
        int minSubarray = 0;
        
        for(int i=0, currSum = 0; i<n; i++) {
            totalSum += cardPoints[i];
            currSum += cardPoints[i];
            if(i < n-k) minSubarray += cardPoints[i];
            else {
                currSum -= cardPoints[i-(n-k)];
                minSubarray = Math.min(minSubarray, currSum);
            }
        }
        return totalSum - minSubarray;
    }
}