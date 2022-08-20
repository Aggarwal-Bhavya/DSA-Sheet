//Leetcode Q-871
//Minimum Number of Refuel Stops to reach target destination
//Approach 1: Using Dynammic Programming
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N+1];
        
        //the farthest we can go to without any refeuling is startFuel miles
        dp[0] = startFuel;
        for(int i=0; i<N; i++)
            for(int t=i; t>=0; t--)
                //this condition checks our current fuel capacity is capable of 
                //taking us to the next station or not
                //if it is, we store the maximum distance that can be covered
                //by this capacity
                if(dp[t] >= stations[i][0]) 
                    dp[t+1] = Math.max(dp[t+1], (long) (dp[t] + stations[i][1]));
        
        for(int i=0; i<=N; i++)
            if(dp[i] >= target) return i;
        return -1;
    }
}
//Time Complexity = O(n^2)
//Space Complexity = O(n)

//Approach 2: Using PQs and greedy approach
class Solution {
    public int minRefuelStops(int target, int tank, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0, prev = 0;
        
        for(int[] station: stations) {
            int location = station[0];
            int capacity = station[1];
            
            tank -= location - prev;
            
            //we should have refuelled the tank in the past
            while(!pq.isEmpty() && tank < 0) {
                tank += pq.poll();
                ans++;
            }
            
            if(tank < 0)    return -1;
            pq.offer(capacity); // new tank refuel possible
            prev = location;
        }
        
        tank -= target - prev;
        while(!pq.isEmpty() && tank < 0) {
            tank += pq.poll();
            ans++;
        }
        
        if(tank < 0)    return -1;
        return ans;
    }
}
//Time Complexity = O(nlogn)
//Space Complexity = O(n)

//Approach 3: Optimised Approach
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int maxPos = startFuel, ans = 0;
        while(maxPos < target) {
            int curMax = 0, curPos = -1;
            for(int i=0; i<stations.length; i++) {
                if(maxPos >= stations[i][0] && stations[i][1] > curMax) {
                    //storing the max fuel available at a station
                    curMax = stations[i][1];
                    curPos = i;
                }
            }
            
            if(curMax == 0) break;
            ans++;
            maxPos += curMax;
            stations[curPos][0] = Integer.MAX_VALUE;
        }
        return maxPos >= target ? ans : -1;
    }
}