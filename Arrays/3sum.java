//Leetcode Q-15
//3Sum
//Time = O(n^2) Space = O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(nums == null || nums.length == 0)
            return ans;
        
        for(int i=0; i<nums.length; i++) {
            int remaining = 0 - nums[i];
            int start = i+1;
            int end = nums.length-1;
            
            while(start < end) {
                int twoSum = nums[start] + nums[end];
                if(twoSum < remaining)  start++;
                else if(twoSum > remaining)  end--;
                else {
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end]));
                    ans.add(triplet);
                    while(start<end && nums[start] == triplet.get(1)) start++;
                    while(start<end && nums[end] == triplet.get(2)) end--;
                }
            }
            
            while(i+1<nums.length && nums[i]==nums[i+1])    i++;
        }
        return ans;
    }
}