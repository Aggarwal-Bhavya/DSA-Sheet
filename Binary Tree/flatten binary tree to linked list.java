//Leetcode Q-114
//Flatten Binary Tree to a Linked List
class Solution {
    //Approach 1 - Recursive
    //used to create link
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null)    return;
        
        //Reverse postorder motion Right->Left->Root
        flatten(root.right); 
        flatten(root.left); 
        
        root.right = prev; //right is set to previously traversed node to create connection
        root.left = null; //left link is always null
        prev = root; //update previously traversed node to current node
    }

    //Approach 2 - Iterative Stack
    public void flatten(TreeNode root) {
        //base case
        if(root == null)    return;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            
            if(curr.right != null)
                stack.push(curr.right);
            if(curr.left != null)
                stack.push(curr.left);
            if(!stack.isEmpty())
                curr.right = stack.peek();
            curr.left = null;
        }
    }

    //Approach 3 - Morris Traversal
    public void flatten(TreeNode root) {
        //base case
        if(root == null)    return;
        
        while(root != null) {
            if(root.left != null) {
                TreeNode prev = root.left;
                //gets us to the rightmost node of the left subtree
                while(prev.right != null)
                    prev = prev.right;
                //changing connections
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            //keeps the traversal going
            root = root.right;
        }
    }
}