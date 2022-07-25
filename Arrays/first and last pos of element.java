//Leetcode Q-34
//First and Last Position of an element in sorted array
//binary Search approach to find start and end indices
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return new int[] {-1, -1};
        int start = firstAndLastPos(nums, target, true);
        if(start == -1) return new int[] {-1, -1};
        int end = firstAndLastPos(nums, target, false);
        return new int[] {start, end};
    }
    
    private int firstAndLastPos(int[] nums, int target, boolean firstOne) {
        int start = 0, end = nums.length-1;
        int ans = -1;
        
        while(start <= end) {
            int mid = start + (end-start) / 2;
            if(nums[mid] > target)  end = mid - 1;
            else if(nums[mid] < target) start = mid + 1;
            else {
                ans = mid;
                if(firstOne)    end = mid-1;
                else    start = mid + 1;
            }
        }
        return ans;
    }
}