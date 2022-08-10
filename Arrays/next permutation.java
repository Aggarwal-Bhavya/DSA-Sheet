//Leetcode Q-31
//Next Permuatation
//The Brute force approach would be to find all possible permutations and then
//locate the given permutation in taht dictionary. Then we could simply find the
//next permuatation.

//Optimised approach
//Time Complexity = O(N) and Space Complexity = O(1)
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1)  return;
        int index1 = nums.length-2;
        while(index1 >= 0 && nums[index1] >= nums[index1+1]) index1--;
        if(index1 >= 0) {
            int index2 = nums.length-1;
            while(nums[index2] <= nums[index1]) index2--;
            swap(nums, index1, index2);
        }
        reverse(nums, index1+1, nums.length-1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while(i < j)    swap(nums, i++, j--);
    }
}