//DFS Traversal of Graph
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        visited[0] = true;
        
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, adj, visited, ans);
        return ans;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        visited[node] = true;
        ans.add(node);
        
        for(Integer neighbour: adj.get(node)) {
            if(visited[neighbour] == false)
                dfs(neighbour, adj, visited, ans);
        }
    }
}
//TC = O(N + 2E) = O(V + E)
//SC = O(N)