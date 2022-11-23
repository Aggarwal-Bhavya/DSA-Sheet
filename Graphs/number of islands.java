//Leetcode Q-200
//Number of islands
//Approach 1: BFS
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    traverse(visited, i, j, grid);
                }
            }
        }
        return count;
    }
    
    private void traverse(boolean[][] visited, int row, int col, char[][] grid) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(row, col));
        visited[row][col] = true;
        
        while(!queue.isEmpty()) {
            List<Integer> curr = queue.poll();
            int i = curr.get(0);
            int j = curr.get(1);
            
            if(isValidNeighbour(i, j+1, grid, visited)) {
                queue.offer(Arrays.asList(i, j+1));
                visited[i][j+1] = true;
            }
            
            if(isValidNeighbour(i, j-1, grid, visited)) {
                queue.offer(Arrays.asList(i, j-1));
                visited[i][j-1] = true;
            }
            
            if(isValidNeighbour(i+1, j, grid, visited)) {
                queue.offer(Arrays.asList(i+1, j));
                visited[i+1][j] = true;
            }
            
            if(isValidNeighbour(i-1, j, grid, visited)) {
                queue.offer(Arrays.asList(i-1, j));
                visited[i-1][j] = true;
            }
        }
    }
    
    private boolean isValidNeighbour(int row, int col, char[][] grid, boolean[][] visited) {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || visited[row][col] == true || grid[row][col] == '0')
            return false;
        return true;
    }
}
//TC = O(n^2) and SC = O(n^2)

//Approach 2: recursive
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int noOfIslands = 0;
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++) 
                if(grid[i][j] == '1') {
                    markNewIsland(grid, i, j);
                    noOfIslands++;
                }
        return noOfIslands;
    }
    public void markNewIsland(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0') 
            return;
        grid[i][j] = '0';
        
        //checking adjacent vertices for 1
        markNewIsland(grid, i-1, j);
        markNewIsland(grid, i+1, j);
        markNewIsland(grid, i, j-1);
        markNewIsland(grid, i, j+1);
    }
}