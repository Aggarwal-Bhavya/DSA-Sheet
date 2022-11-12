//Leetcode Q-169
//Majority Element 1
//element that appears more that Math.floor(n/2)

//Approach 1: HashMap for frequency count
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        int majorityCount = (int)(Math.floor(nums.length/2));
        
        for(int key: map.keySet()) {
            if(map.get(key) > majorityCount)
                return key;
        }
        return -1;
    }
}
//TC = O(n) and SC = O(n)

//Optimised Approach: Moore's Voting Algorithm
//This algorithm works on the fact that if an element occurs more 
//than N/2 times, it means that the remaining elements other than 
//this would definitely be less than N/2.

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;
        
        for(int num: nums) {
            if(count == 0)
                element = num;
            if(element == num)
                count++;
            else count--;
        }
        
        return count >= 1 ? element : -1;
    }
}
//TC = O(n) and SC = O(1)