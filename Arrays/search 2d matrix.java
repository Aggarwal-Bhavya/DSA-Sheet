//Leetcode Q-240
//Search a 2D Matrix II
class Solution {
    //Approach 1 - Brute Force
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[0].length; j++)
                if(matrix[i][j] == target)    return true;
        return false;
    }

    //Approach 2 - Binary Search in Rows or Columns
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null)   
            return false;
        
        for(int i=0; i<matrix.length; i++)
            if(binarySearch(matrix[i], target)) return true;
        
        return false;
    }
    
    public boolean binarySearch(int[] arr, int target) {
        if(target < arr[0] || target > arr[arr.length-1])
            return false;
        int low = 0, high = arr.length;
        while(low < high) {
            int mid = low + (high-low) / 2;
            if(target == arr[mid])  return true;
            if(target > arr[mid])   low = mid + 1;
            else high = mid;
        }
        return false;
    }

    //Optimised Approach - Traversing from top-right or bottom-left corner
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n-1;
        while(i<m && j>=0) {
            if(target == matrix[i][j])  return true;
            if(matrix[i][j] > target)   j--;
            else i++;
        }
        return false;
    }
}