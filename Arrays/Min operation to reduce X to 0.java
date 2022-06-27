//Leetcode- Q1658
//Minimum Operations to reduce X to zero
class Solution {
    //Approach 1
    public int minOperations(int[] nums, int x) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int sum = 0;
        
        for(int n: nums) {
            dq.offer(n);
            if((sum += n) >= x) break;
        }
        
        //meaning we have traversed the complete array but couldn't find a sum
        //which could be equal to x so it basically doesn't exist
        if(sum < x) return -1;
        
        int index = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int count = dq.size();
        for(int i=0; i<count; i++) {
            if(sum == x)    min = Math.min(dq.size(), min);
            sum -= dq.pollLast();
            while(sum < x) {
                dq.offerFirst(nums[index]);
                sum += nums[index--];
            }
        }
        if(sum == x)    min = Math.min(min, dq.size());
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    //Approach 2
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num: nums)  sum += num;
        
        int maxLength = -1, currSum = 0;
        for(int l=0, r=0; r<nums.length; r++) {
            currSum += nums[r];
            while(l<=r && currSum>sum-x)    currSum -= nums[l++];
            if(currSum == sum-x)    maxLength = Math.max(maxLength, r-l+1);
        }
        return maxLength == -1 ? -1 : nums.length-maxLength;
    }
}