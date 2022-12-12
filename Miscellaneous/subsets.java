//Leetcode Q-78
//Subsets

//Return all possible subsets or power set

//Approach 1: Cascading
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());

        for(int num: nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for(List<Integer> curr: ans)
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});

            for(List<Integer> curr: newSubsets)
                ans.add(curr);
        }
        return ans;
    }
}
//TC = O(n*2^n) and SC = O(n*2^n)

//Approach 2: Backtracking
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int k=0; k<n+1; k++)
            backtrack(0, new ArrayList<Integer>(), nums, n, k, ans);
        return ans;
    }

    private void backtrack(int first, List<Integer> curr, int[] nums, int n, int k, List<List<Integer>> ans) {
        if(curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=first; i<n; i++) {
            curr.add(nums[i]);
            backtrack(i+1, curr, nums, n, k, ans);
            curr.remove(curr.size()-1);
        }
    }
}
//TC = O(n*2^n) and SC = O(n)

