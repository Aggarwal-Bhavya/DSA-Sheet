//Check for cycle in undirected graph

//Approach 1: Using BFS
class Solution {
    class Pair {
        int val;
        int parent;
        
        Pair(int val, int parent) {
            this.val = val;
            this.parent = parent;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++)
            visited[i] = false;
        for(int i=0; i<V; i++) {
            if(visited[i] == false)
                if(checkForCycle(i, adj, visited))
                    return true;
        }
        return false;
        
    }
    
    private boolean checkForCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(node, -1));
        while(!queue.isEmpty()) {
            int n = queue.peek().val;
            int parent = queue.peek().parent;
            queue.remove();
            
            for(int neighbour: adj.get(n)) {
                if(visited[neighbour] == false) {
                    visited[neighbour] = true;
                    queue.add(new Pair(neighbour, n));
                } else if(parent != neighbour)
                    return true;
            }
        }
        return false;
    }
}
//TC = O(V + 2E) and SC = O(V)