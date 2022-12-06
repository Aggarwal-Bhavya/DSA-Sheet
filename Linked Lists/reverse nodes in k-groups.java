//Leetcode Q-25
//Reverse Nodes in k-Groups

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = dummy, prev = dummy, nex = dummy;
        
        int count = 0;
        while(curr.next != null) {
            curr = curr.next;
            count++;
        }
        
        while(count >= k) {
            curr = prev.next;
            nex = curr.next;
            
            for(int i=1; i<k; i++) {
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            count -= k;
        }
        return dummy.next;
    }
}
//TC = O(n) and SC = O(1)