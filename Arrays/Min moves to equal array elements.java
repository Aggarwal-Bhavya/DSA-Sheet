//Leetcode Q-462
//Minimum moves to equal array elements
class Solution {
    //Approach 1- Sorting the array and take mid element
    //O(n logn) time and O(1) space	
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0, mid = nums[nums.length/2];
        for(int elem: nums) {
            count += Math.abs(elem - mid);
        }
        return count;
    }

    //Approach 2- Quick Select to change O(n log n) -> O(n)
    public int minMoves2(int[] nums) {
        int count = 0, mid = quickSelect(nums, 0, nums.length-1, nums.length/2);
        for(int elem: nums)
            count += Math.abs(elem-mid);
        return count;
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if(left == right)   return nums[left];
        
        int pIndex = new Random().nextInt(right-left+1) + left;
        pIndex = partition(nums, left, right, pIndex);
        
        if(pIndex == k) return nums[k];
        else if(pIndex < k) return quickSelect(nums, pIndex+1, right, k);
        return quickSelect(nums, left, pIndex-1, k);
    }
    
    private int partition(int[] nums, int left, int right, int pIndex) {
        int pivot = nums[pIndex];
        swap(nums, pIndex, right);
        pIndex = left;
        
        for(int i=left; i<=right; i++)
            if(nums[i] <= pivot)    swap(nums, i, pIndex++);
        
        return pIndex-1;
    }
    
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}