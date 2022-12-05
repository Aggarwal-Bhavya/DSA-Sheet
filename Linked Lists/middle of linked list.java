//Leetcode Q-876
//Middle of the Linked List

//Approach 1- Brute Force: with help of length variable
class Solution {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        
        len = len / 2;
        ListNode curr = head;
        while(len > 0) {
            curr = curr.next;
            len--;
        }
        return curr;
    }
}

//Approach 2- Slow & Fast pointers
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

//TC = O(n) and SC = O(1)