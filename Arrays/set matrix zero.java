//Leetcode Q-73
//Set Matrix Zeroes
//Approach 1 - Brute force
//Time Complexity = O(m*n) and Space Complexity = O(m+n)
    public void setZeroes(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(rows.contains(i) || cols.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }

//Approach 2 - Brute Force but constant space
//Works iff matrix[i][j] is non-negative numbers
//Time Complexity = O((n*m)*(n+m)) 
//where (n*m) for completely traversing the 2D matrix and (n+m) for traversing rows and columns for 0 value element
//Space Complexity = O(1)
    public void setZeroes(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(matrix[i][j] == 0) {
				  //Rows above
                    int index = i-1;
                    while(index >= 0) {
                        if(matrix[index][j] != 0)   matrix[index][j] = -1;
                        index--;
                    }
                    //Rows below
                    index = i+1;
                    while(index < r) {
                        if(matrix[index][j] != 0)   matrix[index][j] = -1;
                        index++;
                    }
				  //Columns left
                    index = j-1;
                    while(index >= 0) {
                        if(matrix[i][index] != 0)   matrix[i][index] = -1;
                        index--;
                    }
				  //Columns right
                    index = j+1;
                    while(index < c) {
                        if(matrix[i][index] != 0)   matrix[i][index] = -1;
                        index++;
                    }
                }
            }
        }
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(matrix[i][j] == -1)  matrix[i][j] = 0;
            }
        }
    }

//Approach 3 - Use dummy array to manage rows and columns which contain 0 values
//Time Complexity = O(n*m) and Space Complexity = O(n+m)
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] dummy1 = new int[rows];
        int[] dummy2 = new int[cols];
        Arrays.fill(dummy1, -1);
        Arrays.fill(dummy2, -1);
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(matrix[i][j] == 0) {
                    dummy1[i] = 0;
                    dummy2[j] = 0;
                }
            }
        }
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(dummy1[i] == 0 || dummy2[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

//Approach 4 - Optimised solution with no extra space
//Optimised for Approach 2, where matrix's column 0 and row 0 are used as dummy
//Time Complexity = O(n*m) and Space Complexity = O(1)
    public void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;
        
        for(int i=0; i<rows; i++) {
            if(matrix[i][0] == 0)   col0 = 0;
            for(int j=1; j<cols; j++) {
                if(matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
        
        for(int i=rows-1; i>=0; i--) {
            for(int j=cols-1; j>=1; j--) 
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if(col0 == 0) matrix[i][0] = 0;
        }
    }