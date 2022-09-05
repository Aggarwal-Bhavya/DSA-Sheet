//Leetcode Q-110
//Balanced Binary Tree
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
    
    private int dfsHeight(TreeNode root) {
        if(root == null)    return 0;
        
        int lh = dfsHeight(root.left);
        if(lh == -1)    return -1;
        int rh = dfsHeight(root.right);
        if(rh == -1)    return -1;
    
        return Math.abs(lh-rh) > 1 ? -1 : Math.max(lh, rh)+1;
    }
}