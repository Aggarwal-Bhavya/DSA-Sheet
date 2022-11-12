//Leetcode Q-287
//Find the duplicate number
//PS: No modification of array and no extra space

//Floyd's cycle detection method using slow and fast pointer
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        
        fast = nums[0];
        
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
//TC = O(n) and SC = O(1)