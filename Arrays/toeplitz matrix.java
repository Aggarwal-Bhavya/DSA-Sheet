//Leetcode Q-766
//Toeplitz Matrix
//Approach 1: Making diagonal groups and checking for same values
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int r=0; r<matrix.length; r++) {
            for(int c=0; c<matrix[0].length; c++) {
                if(!map.containsKey(r-c))
                    map.put(r-c, matrix[r][c]);
                else if(map.get(r-c) != matrix[r][c])
                    return false;
            }
        }
        return true;
    }
}
//TC = O(m*n) and SC = O(m+n)

//Approach 2: Directly checking up diagonals
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int r=1; r<matrix.length; r++)
            for(int c=1; c<matrix[0].length; c++)
                if(matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }
}
//TC = O(m*n) and SC = O(1)