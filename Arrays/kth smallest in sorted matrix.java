//Leetcode Q-378
//Kth Smallest Element in a Sorted Matrix
class Solution {
    //Approach 1 - Brute Force
    //Time Complexity = O(n^2 logn^2)
    //Space Complexity = O(n^2)
    public int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix.length*matrix.length];
        int start = 0;
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix.length; j++)
                arr[start++] = matrix[i][j];
        Arrays.sort(arr);
        return arr[k-1];
    }

    //Approach 2 - Binary search and optimised count
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, low = matrix[0][0], high = matrix[n-1][n-1];
        while(low < high) {
            int mid = low + (high-low) / 2;
            int count = lessEqual(matrix, mid);
            if(count < k)   low = mid+1;
            else    high = mid;
        }
        return low;
    }
    
    private int lessEqual(int[][] matrix, int target) {
        int count = 0, len = matrix.length, i = len-1, j = 0;
        while(i>=0 && j<len) {
            if(matrix[i][j] > target)   i--;
            else {
                count = count + i + 1;
                j++;
            }
        }
        return count;
    }
}