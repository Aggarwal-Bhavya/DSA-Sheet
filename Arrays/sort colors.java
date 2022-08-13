//Leetcode Q-75
//Sort Colors
//Approach 1: Use in-built Arrays.sort() algorithm
//Approach 2: Count sort
//Time Complexity = O(2N) and Space Complexity = O(1)
class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0)  count0++;
            else if(nums[i]==1) count1++;
            else count2++;
        }
        int i=0;
        while(i<nums.length) {
            if(count0 > 0) {
                nums[i++] = 0;
                count0--;
            } else if(count1 > 0) {
                nums[i++] = 1;
                count1--;
            } else if(count2 > 0) {
                nums[i++] = 2;
                count2--;
            }
        }
    }
}
//Approach 3: Dutch National Flag Algorithm
//Time Complexity = O(n) and Space Complexity = O(1)
//Link to image explanation: https://www.autodraw.com/share/41XBBLHOIA77
class Solution {
    //Link to image explanation: https://www.autodraw.com/share/FZPN2CBOE9S5
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;
        int temp;
        while(mid <= high) {
            switch(nums[mid]) {
                case 0: {
                    temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                
                case 1: mid++;
                        break;
                
                case 2: {
                    temp = nums[high];
                    nums[high] = nums[mid];
                    nums[mid] = temp;
                    high--;
                    break;
                }
            }
        }
    }
}