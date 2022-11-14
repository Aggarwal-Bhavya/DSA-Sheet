//Leetcode Q-229
//Majority Element 2

//Brute Force: Nested loop
//Approach 2: HashMap
//Approach 3: Extended Moore's Voting Algorithm
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0;
        for(int num: nums) {
            if(num == num1)     count1++;
            else if(num == num2)    count2++;
            else if(count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if(count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int num: nums) {
            if(num == num1) count1++;
            else if(num == num2)    count2++;
        }
        if(count1 > (int)(Math.floor(nums.length/3)))
            ans.add(num1);
        if(count2 > (int)(Math.floor(nums.length/3)))
            ans.add(num2);
        
        return ans;
    }
}
//TC = O(n) and SC = O(1)