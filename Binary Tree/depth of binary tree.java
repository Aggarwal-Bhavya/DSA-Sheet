//Leetcode Q-104
//Maximum Depth of Binary Tree
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)    return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int num = queue.size();
            depth++;
            for(int i=0; i<num; i++) {
                TreeNode next = queue.poll();
                if(next.left != null)   queue.offer(next.left);
                if(next.right != null)  queue.offer(next.right);
            }
        }
        return depth;
    }
}