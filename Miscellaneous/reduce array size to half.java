//Leetcode Q-1338
//Reduce Array Size to the Half
//Approach 1: Using hashmap and priority queue
//Time Complexity = O(n) and Space Complexity = O(n)
class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        if(n==1 || n==2)    return 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        //a hash map to map the int-count pair
        for(Integer val: arr)
            map.put(val, map.getOrDefault(val, 0)+1);
        
        //max priority queue to store max frequency first
        for(Integer val: map.values())
            pq.offer(val);
        
        //res ensures that we reach atleast n/2 and count is the number of unique values we eliminate
        int res = 0, count = 0;
        //while resultant should reach upto n/2 and pq holding all frequencies doesn't become empty
        while(res < n/2 && pq.size() > 0) {
            res += pq.poll();
            count++;
        }
        return count;
    }
}

//Approach 2:
class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        if(n == 1 || n == 2)    return 1;
        
        int max = 0, min = 1000000;
        for(int val: arr) {
            max = Math.max(max, val);
            min = Math.min(min, val);
        }
        
        int[] count = new int[max-min+1];
        for(int val: arr) {
            count[val-min]++;
        }
        
        int[] bucket = new int[n+1];
        for(int val: count) {
            if(val != 0)    bucket[val]++;
        }
        
        int size = 0, sum = 0;
        final int half = n/2;
        for(int i=arr.length; i>0; i--) {            
            while(bucket[i]-- != 0) {
                sum += i;
                size++;
                if(sum >= half)    return size;
            }
        }
        return 0;
    }
}
