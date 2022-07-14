//Leetcode Q-105
//Construct Binary Tree from Preorder and Inorder Traversal
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preorderIndex;
    //mapping value -> index
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);
        
        return arrayToTree(preorder, 0, preorder.length-1);
    }
    public TreeNode arrayToTree(int[] preorder, int left, int right) {
        if(left > right)    return null;
        
        //find the root element
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        //building left and right subtree around root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue)-1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue)+1, right);
        return root;
    }
}