/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    private ListNode rev(ListNode head){
        if(head == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
           slow = slow.next;
           fast = fast.next.next;
        }
        ListNode curr2 = slow.next;
        slow.next = null;
        ListNode newhead = rev(curr2);
        ListNode first = head;
        while(newhead != null){
            ListNode t1 = first.next;
            ListNode t2 = newhead.next;

            first.next = newhead;
            newhead.next = t1;

            first = t1;
            newhead = t2;
        }
    }
}
