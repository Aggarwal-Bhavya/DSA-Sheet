//Leetcode Q-1235
//Maximum Profit in Job Scheduling

//Approach 1: DP using TreeMap
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        
        //jobs 2D array is created with values start, end and profit
        for(int i=0; i<n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        //jobs are sorted on the basis of their end time i.e jobs[1]
        Arrays.sort(jobs, (a,b) -> (a[1] - b[1]));
        
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0,0);
        
        for(int[] job: jobs) {
            int val = job[2] + dp.floorEntry(job[0]).getValue();
            if(val > dp.lastEntry().getValue())
                dp.put(job[1], val);
        }
        
        return dp.lastEntry().getValue();
    }
}
//TC = O(nlogn) and SC = O(n)