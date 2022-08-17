//Binary Tree Pre-order DFS Traversal
//In pre-order traversal, the tree is traversed in the order of root->left->right.
//Meaning the root is approached first, then its corresponing left subtree and, then its right subtree. 
//For all the subtrees of the parent node same process is repeated.
//-If you know you need to explore the roots before inspecting any leaves, you pick pre-order because
//you will encounter all the roots before all of the leaves.
//-Used to create a copy of a tree. For example, if you want to create a replica of a tree, put the
//nodes in an array with a pre-order traversal. Then perform an Insert operation on a new tree for 
//each value in the array. You will end up with a copy of your original tree.

//Approach 1: Recusrive Solution
//We recursively call the method so as to traverse the tree in pre-order DFS 
//traversal.
class Solution {
    //Preorder Traversal = root -> left -> right
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        recursiveTraversal(root);
        return ans;
    }
    
    private void recursiveTraversal(TreeNode node) {
        if(node == null)    return;
        ans.add(node.val);
        recursiveTraversal(node.left);
        recursiveTraversal(node.right);
    }
}
//Time Complexity = O(n) where n is the number of nodes
//Space Complexity = O(h) (because of the call stacks) where h is the height of the tree
//(note: in worst case when the tree is skewed the height of the tree would be equal 
//to number of nodes, so space complexity would be O(n)).

//Approach 2: Iterative Approach
//Here, we create an explicit stack as opposed to using the in-built call stack as seen in 
//recursive approach. Stack operates on LIFO (Last In First Out), so we will push right child node first and then left child.
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if(root == null)    return preorder;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            preorder.add(root.val);
            if(root.right != null)
                stack.push(root.right);
            if(root.left != null)
                stack.push(root.left);
        }
        return preorder;
    }
}
//Time Complexity = O(n)
//Space Complexity = O(h)