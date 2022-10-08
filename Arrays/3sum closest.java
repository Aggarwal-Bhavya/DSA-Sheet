//Leetcode Q-16
//3 Sum closest

//Approach 1: TC = O(N^2+N*logN)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if(n == 3)
            return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int maxSum = nums[n-1] + nums[n-2] + nums[n-3];
        
        if(target > maxSum) return maxSum;
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int i=0; i<n-2; i++) {
            int left = i+1, right = n-1;
            while(left < right) {
                maxSum = nums[i] + nums[right-1] + nums[right];
                if(target-maxSum > Math.abs(minDiff))
                    break;
                
                int minSum = nums[i] + nums[left] + nums[left+1];
                if(minSum-target > Math.abs(minDiff))
                    break;
                
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target)   return sum;
                int diff = sum - target;
                if(Math.abs(diff) < Math.abs(minDiff))
                    minDiff = diff;
                
                if(diff > 0)    right--;
                else    left++;
            }
        }
        return target + minDiff;
    }
}