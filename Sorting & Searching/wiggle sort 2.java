//Leetcode Q-324
//Wiggle Sort II
//Approach 1: TC = O(nlogn) SC = O(n)
class Solution {
    public void wiggleSort(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            arr[i] = nums[i];
        int n = nums.length-1;
        Arrays.sort(arr);
        for(int i=1; i<nums.length; i+=2)
            nums[i] = arr[n--];
        for(int i=0; i<nums.length; i+=2)
            nums[i] = arr[n--];
    }
}

