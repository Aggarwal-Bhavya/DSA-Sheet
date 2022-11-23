//Leetcode Q-994
//Rotting oranges

//Approach 1: BFS with extra space
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<List<Integer>> queue = new LinkedList<>();
        int[][] visited = new int[m][n];
        int countFresh = 0;
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(Arrays.asList(i, j, 0));
                    visited[i][j] = 2;
                }
                else    visited[i][j] = 0;
                if(grid[i][j] == 1) countFresh++;
            }
        int time = 0;
        int[] dx = new int[]{0, 0, +1, -1};
        int[] dy = new int[]{+1, -1, 0, 0};
        int count = 0;
        
        while(!queue.isEmpty()) {
            List<Integer> curr = queue.poll();
            int r = curr.get(0);
            int c = curr.get(1);
            int t = curr.get(2);
            time = Math.max(time, t);
            
            for(int i=0; i<4; i++) {
                int row = r+dx[i];
                int col = c+dy[i];
                
                if(row>=0 && row<m && col>=0 && col<n && visited[row][col] != 2 && grid[row][col] == 1) {
                    queue.offer(Arrays.asList(row, col, t+1));
                    visited[row][col] = 2;
                    count++;
                }
            }
        }
        if(count != countFresh) return -1;
        return time;
    }
}
//TC = O(mxn) and SC = O(mxn)