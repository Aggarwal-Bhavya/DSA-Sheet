//Leetcode Q-23
//Merge K sorted lists
//Given an array of k linked lists (sorted) to arrange them in a single linked list
//of sorted order.
//Approach 1: Traverse the linked lists, store the elements in an list and sort it externally.
//TC: O(nlogn) and SC = O(n) n=total number of elements
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        
        for(ListNode ln: lists) {
            while(ln != null) {
                list.add(ln.val);
                ln = ln.next;
            }
        }
        
        Collections.sort(list);
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(int i: list) {
            ListNode temp = new ListNode(i);
            head.next = temp;
            head = head.next;
        }
        head.next = null;
        return dummy.next;
    }
}

//Approach 2: Compare one by one. We start with the head of each i.e. k linked list
//Compare each head if less or equal add it and move on
//TC = O(kn) and SC = O(1)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int minIndex = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for(int i=0; i<lists.length; i++) {
                if(lists[i] != null) {
                    if(lists[i].val < min) {
                        minIndex = i;
                        min = lists[i].val;
                    }
                    isBreak = false;
                }
            }
            if(isBreak)
                break;

            head.next = lists[minIndex];
            head = head.next;
            lists[minIndex] = lists[minIndex].next;
        }
        head.next = null;
        return dummy.next;
    }
}

//Approach 3: