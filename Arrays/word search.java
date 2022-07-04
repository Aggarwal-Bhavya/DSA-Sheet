//Leetcode Q-79
//Word Search - DFS Approach
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int row = board.length, col = board[0].length;
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++)
                if(dfs(board, words, 0, i, j))  return true;
        return false;
    }
    
    private boolean dfs(char[][] board, char[] words, int index, int i, int j) {
        if(index == words.length)   return true;
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j]=='#' || board[i][j]!=words[index])
            return false;
        
        char temp = board[i][j];
        board[i][j] = '#';  //indication that we've visited this location
        
        boolean flag1 = dfs(board, words, index+1, i+1, j);
        boolean flag2 = dfs(board, words, index+1, i-1, j);
        boolean flag3 = dfs(board, words, index+1, i, j+1);
        boolean flag4 = dfs(board, words, index+1, i, j-1);
        
        boolean flag = flag1 || flag2 || flag3 || flag4;
        if(!flag)   board[i][j] = temp;
        return flag;
    }
}
