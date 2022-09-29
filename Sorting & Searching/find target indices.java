//Leetcode Q-2089
//Find target indices after sorting array
//Brute approach: O(nlogn)
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == target)
                ans.add(i);
        }
        return ans;
    }
}

//Optimal: O(n)
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lesser = 0, equal = 0;
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < target)
                lesser++;
            else if(nums[i] == target)
                equal++;
        }
        
        for(int i=lesser; i<lesser+equal; i++)
            ans.add(i);
        
        return ans;
    }
}
