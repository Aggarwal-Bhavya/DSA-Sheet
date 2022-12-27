//Leetcode Q-64
//Minimum Path Sum

//Approach 1: DP with memoization
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return minPathSum(grid, dp, m-1, n-1);
    }

    public int minPathSum(int[][] grid, int[][] dp, int i, int j) {
        if(i==0 && j==0)    return grid[0][0];
        if(i < 0 || j < 0)  return (int)Math.pow(10, 9);
        if(dp[i][j] != -1)  return dp[i][j];

        int up = grid[i][j] + minPathSum(grid, dp, i-1, j);
        int left = grid[i][j] + minPathSum(grid, dp, i, j-1);

        return dp[i][j] = Math.min(up, left);
    }
}

//Approach 2: DP in tabular format
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0)    dp[i][j] = grid[0][0];
                else {
                    int up = grid[i][j];
                    if(i > 0)   up += dp[i-1][j];
                    else up += (int)Math.pow(10, 9);

                    int left = grid[i][j];
                    if(j > 0)   left += dp[i][j-1];
                    else left += (int)Math.pow(10, 9);

                    dp[i][j] = Math.min(up, left);
                }
            }  
        }
        return dp[m-1][n-1];
    }
}

//Approach 3: Tabular DP with space optimisation
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] prev = new int[n];
        for(int i=0; i<m; i++) {
            int[] temp = new int[n];
            for(int j=0; j<n; j++) {
                if(i==0 && j==0)    temp[j] = grid[i][j];
                else {
                    int up = grid[i][j];
                    if(i>0) up += prev[j];
                    else up += (int)Math.pow(10, 9);

                    int left = grid[i][j];
                    if(j>0) left += temp[j-1];
                    else left += (int)Math.pow(10, 9);

                    temp[j] = Math.min(up, left); 
                }
            }
            prev = temp;
        }
        return prev[n-1];
    }
}