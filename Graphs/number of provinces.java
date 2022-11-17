//Leetcode Q-547
//Number of Provinces
//or number of componenets in our graph

//Approach 1: without visited array(DFS)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        
        for(int i=0; i<isConnected.length; i++) {
            if(isConnected[i][i] == -1)
                continue;
            count++;
            //instead of using visited array, we update the connection matrix itself
            isConnected[i][i] = -1;
            traverse(i, isConnected);
        }
        return count;
    }
    
    private void traverse(int node, int[][] isConnected) {
        for(int i=0; i<isConnected[node].length; i++) {
            if(isConnected[node][i] == -1 || isConnected[node][i] == 0)
                continue;
            isConnected[node][i] = -1;
            isConnected[i][node] = -1;
            traverse(i, isConnected);
        }
    }
}
//TC = O(N + 2E) and SC = O(N)


//Approach 2: DFS with extra space
class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i=0;i<isConnected.length;i++){
            if (visited[i]) continue;
            count++;
            visited[i] = true;
            traverse(i,isConnected,visited);
        }
        return count;
        

    }
    
    private void traverse(int index,int[][] isConnected,boolean[] visited){

        for(int i=0;i<isConnected[index].length;i++){
            if (visited[i] || isConnected[index][i] == 0) continue;
            if (i == index) {
                visited[i] = true;
                continue;
            }
            visited[i] = true;
            traverse(i,isConnected,visited);
        }
    }
}
