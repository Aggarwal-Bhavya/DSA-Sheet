//BFS Traversal of Graph
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            bfs.add(node);
            
            for(Integer neighbour: adj.get(node)) {
                if(visited[neighbour] == false) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        return bfs;
    }
}
//TC = O(N) + O(2E) = O(N+E)
//SC = O(N)