//Leetcode Q-116
//Populating Next Right Pointers in Each Node
//Approach 1: Simple BFS
class Solution {
    public Node connect(Node root) {
        if(root == null)    return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node dummy = new Node(0);
            while(size-- > 0) {
                Node node = queue.remove();
                dummy.next = node;
                dummy = dummy.next;
                
                if(node.left != null)   queue.offer(node.left);
                if(node.right != null)  queue.offer(node.right);
            }
        }
        return root;
    }
}
//Time Complexity = O(n)
//Space Complexity = O(n)


//Approach 2: Here, we have DFS + BFS propogation
//We use the parent's next to establish the next pointer
//for other child nodes.
class Solution {
    public Node connect(Node root) {
        connectHelper(root, null, true);
        return root;
    }
    
    //tracking each node parent and pointing current node next to its parent right child
    private void connectHelper(Node node, Node parent, boolean isLeftChild) {
        if(node == null)    return;
        
        //if root node, parent would be numm and its, next would be null
        if(parent == null)  node.next = null;
        else {
            //since it's perfect tree, the left child would point to the parent's right node
            if(isLeftChild)     node.next = parent.right;
            //if parent.next == null means that it's the right most node and no more node, so next would
            //go onto null, otherwise, it would go to parent's next left child
            else    node.next = parent.next == null ? null : parent.next.left;
        }
        connectHelper(node.left, node, true);
        connectHelper(node.right, node, false);
    }
}
//Time Complexity = O(n)
//Space Complexity = O(n) ~O(1) because in question it mentions that implicit stack isn't to be considered as extra space


//Approach 3: Optimised space complexity approach
//We use to pointers, one curr for the current node (traverse on the next level)
//and second nextLevel to hop onto the next level (it eliminates queue).
class Solution {
    public Node connect(Node root) {
        if(root == null)    return root;
        
        Node curr = root;
        Node nextLevel = root != null ? root.left : null;
        
        while(curr != null && nextLevel != null) {
            curr.left.next = curr.right;
            if(curr.next != null)   
                curr.right.next = curr.next.left;
            
            curr = curr.next; // move curr pointer in same level forward
            if(curr == null) {
                //if curr reaches right most node in current level, goto next level now
                curr = nextLevel;
                nextLevel = nextLevel.left;
            }
        } 
        return root;
    }
}
//Time Complexity = O(n)
//Space Complexity = O(1)