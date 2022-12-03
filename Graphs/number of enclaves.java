//Leetcode Q-1020
//Number of Enclaves
//BFS Approach
class Solution {
    class Pair {
        int x;
        int y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int numEnclaves(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 || j==0 || i==m-1 || j==n-1) 
                    if(grid[i][j] == 1) {
                        queue.add(new Pair(i, j));
                        visited[i][j] = 1;
                    }
            }
        }
        
        int[] dx = new int[]{-1, 0, +1, 0};
        int[] dy = new int[]{0, -1, 0, +1};
        
        while(!queue.isEmpty()) {
            Pair val = queue.poll();
            int row = val.x;
            int col = val.y;
            for(int i=0; i<4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];
                
                if(newRow >=0 && newRow < m && newCol >= 0 && newCol < n && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                    queue.add(new Pair(newRow, newCol));
                    visited[newRow][newCol] = 1;
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<m; i++) 
            for(int j=0; j<n; j++) 
                if(grid[i][j] == 1 && visited[i][j] == 0)
                    count++;
        return count;
    }
}
//TC = O(m*n) and SC = O(m*n)