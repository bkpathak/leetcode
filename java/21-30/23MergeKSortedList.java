/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((n1, n2) -> { return n1.val - n2.val;} );
        for (ListNode n : lists) {
            if (n != null) heap.offer(n);
        } 
        
        while (!heap.isEmpty()) {
            ListNode temp = heap.poll();
            node.next = temp;
            node = node.next;
            
            if (temp.next != null) heap.offer(temp.next);
        }
        
        return head.next;
        
    }
}