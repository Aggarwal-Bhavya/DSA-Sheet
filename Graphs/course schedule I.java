//Leetcode Q-207
//Course Schedule I

//Cycle Detection using topological sort
class Solution {
    public boolean canFinish(int V, int[][] dependencies) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++)
            adj.add(new ArrayList<Integer>());
        int n = dependencies.length;
        for(int i=0; i<n; i++) {
            adj.get(dependencies[i][1]).add(dependencies[i][0]);
        }
        
        int[] indegree = new int[V];
        for(int i=0; i<V; i++) {
            for(int list: adj.get(i))
                indegree[list]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<V; i++) {
            if(indegree[i] == 0)
                queue.offer(i);
        }
        
        List<Integer> topo = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);
            
            for(int list: adj.get(node)) {
                indegree[list]--;
                if(indegree[list] == 0)
                    queue.offer(list);
            }
        }
        
        if(topo.size() == V)    return true;
        return false;
    }
}
