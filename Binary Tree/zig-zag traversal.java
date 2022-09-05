//Leetcode Q-103
//Zig zag level order traversal
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;
        dfs(res, root, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, TreeNode node, int level) {
        if(node == null)    return;
        if(res.size() == level)
            res.add(new ArrayList<>());
        if(level % 2 == 0)
            res.get(level).add(node.val);
        else
            res.get(level).add(0, node.val);
        
        dfs(res, node.left, level+1);
        dfs(res, node.right, level+1);
    }
}