//Leetcode Q-41
//First Missing Positive Number
//Runs in O(n) time and uses constant space complexity
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int correctPos = nums[i]-1; //because of 0 indexing we need to -1
            while(1 <= nums[i] && nums[i] <= n && nums[i] != nums[correctPos]) {
                //swapping operation
                int temp = nums[i];
                nums[i] = nums[correctPos];
                nums[correctPos] = temp;
                //updating the new correctPos as nums[i] has been changed, otherwise it would skip the value
                correctPos = nums[i]-1;
            }
        }
        
        //traversing to check which index-value do not match
        for(int i=0; i<n; i++)
            if(i+1 != nums[i])  return i+1;
        return n+1;
    }
}
//If not considering the constant space constraint our intital approach would be 
//to create an extra space data structure which monitors the value and count.
//Which ever index would have the count 0 would be the answer.
//Its space complexity would have been O(n) and in some cases it could be
//O(max(array)) as we would need only space which could go till the highest value.
//However, it can be permanently reduced to O(n) because the smallest missing number
//would likely be in the range 1 to N+1.