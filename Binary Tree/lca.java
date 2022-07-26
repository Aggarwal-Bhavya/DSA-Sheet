//Leetcode Q-236
//Lowest Common Ancestor problem in Binary Tree
class Solution {
    //Approach 1 = Recursive DFS Traversal
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //result
        if(left == null)    return right;
        else if(right == null)  return left;
        else
            //both are not null and we have found p, q and hence the lca is their root
            return root;
    }
}